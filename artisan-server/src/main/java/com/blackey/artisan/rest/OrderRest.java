package com.blackey.artisan.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.component.domain.NotifyRecord;
import com.blackey.artisan.component.domain.User;
import com.blackey.artisan.component.service.*;
import com.blackey.artisan.dto.bo.OrderBo;
import com.blackey.artisan.dto.bo.OrderInfoBo;
import com.blackey.artisan.dto.bo.SumBo;
import com.blackey.artisan.global.constants.NotifyContent;
import com.blackey.artisan.global.constants.NotifyStatus;
import com.blackey.artisan.global.constants.NotifyType;
import com.blackey.artisan.global.constants.OrderStatus;
import com.blackey.common.rest.BaseRest;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.Order;
import com.blackey.artisan.dto.form.OrderForm;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@RestController
@RequestMapping("/artisan/order")
public class OrderRest extends BaseRest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ServiceProcessService serviceProcessService;

    @Autowired
    private NotifyRecordService notifyRecordService;

    @Autowired
    private ShareRelationService shareRelationService;

    @Autowired
    private UserService userService;

    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:order:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);
        return success(page);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody OrderForm orderForm){

        Order order = new Order();
        //Form --> domain
        BeanUtils.copyProperties(orderForm,order);

        orderService.save(order);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Order order){
        OrderInfoBo order1 = orderService.detail(order.getId());
        if (order1.getOrderStatus() == OrderStatus.DONE){
            return success();
        }

        String notifyOpenId = shareRelationService.exsitParent(order1.getOpenId());

        User user = userService.findByOpenId(order1.getOpenId());

        if(order.getOrderStatus().equals(OrderStatus.DONE) &&
                !notifyOpenId.equals("")){
            NotifyRecord notifyRecord = new NotifyRecord();
            notifyRecord.setNotifyContent(
                    String.format(
                    NotifyContent.notifyOrderUrl,order1.getPrice(),order1.getOrderNo(),order1.getPrice()));
            notifyRecord.setObjectId(order.getId());
            notifyRecord.setNotifyUserName(user.getNickName());
            notifyRecord.setNotifyType(NotifyType.ORDER);
            notifyRecord.setNotifyStatus(NotifyStatus.NOTIFY);
            notifyRecord.setNotifyUserOpenid(notifyOpenId);

            User friend = userService.findByOpenId(notifyOpenId);
            friend.setFriendScore(friend.getFriendScore() + order1.getPrice());

            userService.updateById(friend);
            notifyRecordService.save(notifyRecord);
        }
        user.setMyScore(user.getMyScore() + order1.getPrice());


        userService.updateById(user);
        orderService.updateById(order);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        orderService.removeById(id);
        return success();
    }

    @PostMapping("/main/order")
    public Result mainOrder(@RequestBody OrderForm form){
        Page<OrderInfoBo> page = new Page<>(1,5);
        page.setRecords(orderService.getMainPageOrderList(form,page));
        for (OrderInfoBo orderinfoBo: page.getRecords()
             ) {
            if(orderinfoBo.getOrderStatus() == OrderStatus.SERVICE){
                try {
                    orderinfoBo.setContent(serviceProcessService.queryOneByOrderId(orderinfoBo.getId()).getContent());
                }catch (Exception e){
                    orderinfoBo.setContent("");
                }
            }
        }
        return success(page);
    }

    @PostMapping("/list")
    public Result orderList(@RequestBody OrderForm form){
        Page<OrderInfoBo> page = new Page<>(form.getCurrent(),form.getSize());
        return success(page.setRecords(orderService.getOrderList(form,page)));
    }

    @PostMapping("/booking")
    public Result booking(@RequestBody OrderForm form){
        orderService.bookingService(form);
        return success();
    }

    @PostMapping("/confirm")
    public Result confirm(@RequestBody OrderForm form){
        orderService.confirmService(form);
        return success();
    }

    @RequestMapping("/detail/{id}")
    public Result info(@PathVariable("id") String id){
        return success(orderService.detail(id));
    }

    @RequestMapping("/user")
    Result getUserOrderCount(@RequestParam String openId){
        return success(orderService.getUserOrderCount(openId));
    }
}
