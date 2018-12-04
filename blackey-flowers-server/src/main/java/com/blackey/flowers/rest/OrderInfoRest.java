package com.blackey.flowers.rest;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.flowers.component.domain.UserInfo;
import com.blackey.flowers.component.service.UserInfoService;
import com.blackey.flowers.dto.bo.OrderInfoBo;
import com.blackey.flowers.dto.form.OrderStatusChangeForm;
import com.blackey.flowers.dto.form.PayUnifiedOrderForm;
import com.blackey.flowers.global.constants.OrderStatus;
import com.blackey.flowers.global.constants.PayStatus;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/flowers/order")
public class OrderInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoRest.class);

    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    UserInfoService userInfoService;


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
     * 前端分页列表
     */
    @PostMapping("/wechat/list/page")
    public Result getOrderlistPage(@RequestBody OrderInfoForm orderInfoForm){


        Page<OrderInfoBo> page = new Page<>(orderInfoForm.getCurrent(),orderInfoForm.getSize());

        List<OrderInfoBo> orderlistPage = orderInfoService.getOrderlistPage(orderInfoForm, page);

        return success(page.setRecords(orderlistPage));
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


        UserInfo userInfo = userInfoService.findByOpenId(orderInfoForm.getOpenId());
        if(userInfo == null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }

        OrderInfo orderInfo = new OrderInfo();
        //Form --> domain
        BeanUtils.copyProperties(orderInfoForm,orderInfo);
        orderInfo.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        orderInfo.setPayStatus(PayStatus.DEFAULT.getName());
        orderInfo.setTradeStatus(OrderStatus.WAIT_PAY);
        orderInfo.setUserNo(userInfo.getId());
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
     * 订单状态修改
     */
    @PostMapping("/status/change")
    public Result update(@RequestBody OrderStatusChangeForm form){

        orderInfoService.changeOrderStatus(form.getOrderNo(),form.getOrderStatus());

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

    /**
     * 调用统一下单接口，并组装生成支付所需参数对象.
     *
     * @param payUnifiedOrderForm 统一下单请求参数
     * @return 返回 {@link com.github.binarywang.wxpay.bean.order}包下的类对象
     */
    @ApiOperation(value = "统一下单，并组装所需支付参数")
    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody PayUnifiedOrderForm payUnifiedOrderForm) throws WxPayException {

        return success(orderInfoService.createOrder(payUnifiedOrderForm));
    }

    /**
     * 支付回调通知处理
     * @param xmlData
     * @return
     * @throws WxPayException
     */
    @PostMapping("/notify/order")
    public Result parseOrderNotifyResult(@RequestBody String xmlData) throws WxPayException {

        orderInfoService.parseOrderNotifyResult(xmlData);

        return success();
    }




}
