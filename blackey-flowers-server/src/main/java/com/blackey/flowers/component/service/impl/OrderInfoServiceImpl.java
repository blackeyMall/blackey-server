package com.blackey.flowers.component.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackey.flowers.component.domain.UserInfo;
import com.blackey.flowers.component.service.UserInfoService;
import com.blackey.flowers.dto.bo.OrderInfoBo;
import com.blackey.flowers.dto.form.OrderInfoForm;
import com.blackey.flowers.dto.form.PayUnifiedOrderForm;
import com.blackey.flowers.global.constants.OrderStatus;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.flowers.component.mapper.OrderInfoMapper;
import com.blackey.flowers.component.domain.OrderInfo;
import com.blackey.flowers.component.service.OrderInfoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 订单信息表 OrderInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Service
public class OrderInfoServiceImpl extends BaseServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    @Autowired
    WxPayService wxService;
    @Autowired
    UserInfoService userInfoService;




    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderInfo> page = (Page<OrderInfo>) this.page(
                new Query<OrderInfo>(params).getPage(),
                new QueryWrapper<OrderInfo>()
        );

        return new PageUtils(page);
    }

    @Override
    public void changeOrderStatus(String orderNo, OrderStatus orderStatus) {

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setTradeStatus(orderStatus);
        Wrapper<OrderInfo> updateWrapper = new UpdateWrapper();
        ((UpdateWrapper<OrderInfo>) updateWrapper).eq("order_no",orderNo);

        this.update(orderInfo, updateWrapper);

    }

    /**
     * 统一下单
     *
     * @param payUnifiedOrderForm
     * @return
     */
    @Override
    public <T> T  createOrder(PayUnifiedOrderForm payUnifiedOrderForm) throws WxPayException {

        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        request.setVersion("1.0");
        request.setBody("魔都全城优惠卡券-"+payUnifiedOrderForm.getGoodsName());
        /**
         * 商品描述
         */
        request.setDetail(JSON.toJSONString(payUnifiedOrderForm));
        request.setNonceStr(UUID.randomUUID().toString().replace("-","").substring(0,30));
        request.setSignType("MD5");
        /**
         * 订单号
         */
        String orderNo = UUID.randomUUID().toString().replace("-","");
        request.setOutTradeNo(orderNo);
        request.setTotalFee(payUnifiedOrderForm.getTotalFee());
        request.setSpbillCreateIp("172.0.0.1");
        request.setNotifyUrl("https://www.ssqushe.com/flowers/order/notify");
        request.setTradeType("JSAPI");
        request.setProductId(payUnifiedOrderForm.getGoodsNo());
        request.setOpenid(payUnifiedOrderForm.getOpenId());

        UserInfo userInfo = userInfoService.findByOpenId(payUnifiedOrderForm.getOpenId());

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(orderNo);
        orderInfo.setTradeStatus(OrderStatus.CANCEL);
        orderInfo.setUserNo(userInfo.getId());
        orderInfo.setAmount(new BigDecimal(payUnifiedOrderForm.getTotalFee()));
        orderInfo.setGoodsNo(payUnifiedOrderForm.getGoodsNo());
        orderInfo.setGoodsName(payUnifiedOrderForm.getGoodsName());
        orderInfo.setGoodsType(payUnifiedOrderForm.getGoodsType());
        orderInfo.setGoodsCount(1);
        orderInfo.setRefereeId(payUnifiedOrderForm.getRefereeId());
        this.save(orderInfo);


        return wxService.createOrder(request);
    }

    /**
     * 前段小程序获取订单列表
     *
     * @param orderInfoForm
     * @return
     */
    @Override
    public List<OrderInfoBo> getOrderlistPage(OrderInfoForm orderInfoForm, Page<OrderInfoBo> page) {

        return baseMapper.getOrderlistPage(orderInfoForm,page);
    }

    /**
     * 支付回调方法
     *
     * @param xmlData
     * @return
     */
    @Override
    public void parseOrderNotifyResult(String xmlData) throws WxPayException {

        final WxPayOrderNotifyResult notifyResult = this.wxService.parseOrderNotifyResult(xmlData);

        String transactionId = notifyResult.getTransactionId();
        String outTradeNo = notifyResult.getOutTradeNo();

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(outTradeNo);
        orderInfo.setTransactionId(transactionId);
        orderInfo.setTradeStatus(OrderStatus.SERVICE);

        baseMapper.update(orderInfo,new UpdateWrapper<OrderInfo>().eq("order_no",outTradeNo));

    }

}
