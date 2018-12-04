package com.blackey.flowers.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.flowers.dto.bo.OrderInfoBo;
import com.blackey.flowers.dto.form.OrderInfoForm;
import com.blackey.flowers.dto.form.PayUnifiedOrderForm;
import com.blackey.flowers.global.constants.OrderStatus;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.OrderInfo;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;

import java.util.List;
import java.util.Map;

/**
 * 订单信息表 OrderInfoService
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
public interface OrderInfoService extends BaseService<OrderInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 更新订单状态
     * @param orderNo 订单编号
     * @param orderStatus 订单状态
     */
    void changeOrderStatus(String orderNo, OrderStatus orderStatus);

    /**
     * 统一下单
     * @param payUnifiedOrderForm
     * @param <T>     请使用{@link com.github.binarywang.wxpay.bean.order}包下的类
     * @return
     */
    <T> T createOrder(PayUnifiedOrderForm payUnifiedOrderForm)throws WxPayException;

    /**
     * 前段小程序获取订单列表
     * @param orderInfoForm
     * @return
     */
    List<OrderInfoBo> getOrderlistPage(OrderInfoForm orderInfoForm, Page<OrderInfoBo> page);

    /**
     * 支付回调方法
     * @param xmlData
     * @throws WxPayException
     */
    void parseOrderNotifyResult(String xmlData) throws WxPayException;
}

