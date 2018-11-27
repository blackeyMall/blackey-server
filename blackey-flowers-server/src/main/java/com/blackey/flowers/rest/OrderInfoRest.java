package com.blackey.flowers.rest;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackey.common.rest.BaseRest;
import com.blackey.flowers.global.constants.OrderStatus;
import com.blackey.flowers.global.constants.PayStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.flowers.component.domain.OrderInfo;
import com.blackey.flowers.dto.form.OrderInfoForm;
import com.blackey.flowers.component.service.OrderInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 订单信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@RestController
@RequestMapping("/flowers/orderinfo")
public class OrderInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoRest.class);

    @Autowired
    private OrderInfoService orderInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("flowers:orderinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = orderInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody OrderInfoForm orderInfoForm){

        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderInfoForm,orderInfo);

        Wrapper<OrderInfo> queryWrapper = new QueryWrapper();
        ((QueryWrapper<OrderInfo>) queryWrapper).setEntity(orderInfo);
        List<OrderInfo> orderInfos = orderInfoService.list(queryWrapper);

        return success(orderInfos);
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        OrderInfo orderInfo = orderInfoService.getById(id);

        return success(orderInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody OrderInfoForm orderInfoForm){

        OrderInfo orderInfo = new OrderInfo();
        //Form --> domain
        BeanUtils.copyProperties(orderInfoForm,orderInfo);
        orderInfo.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        orderInfo.setPayStatus(PayStatus.DEFAULT.getName());
        orderInfo.setTradeStatus(OrderStatus.BOOK.getName());
        orderInfoService.save(orderInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody OrderInfo orderInfo){

        orderInfoService.updateById(orderInfo);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        orderInfoService.removeById(id);

        return success();
    }

}
