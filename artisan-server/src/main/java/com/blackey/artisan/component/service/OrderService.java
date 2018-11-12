package com.blackey.artisan.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.dto.bo.OrderInfoBo;
import com.blackey.artisan.dto.bo.SumBo;
import com.blackey.artisan.dto.form.OrderForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.Order;

import java.util.List;
import java.util.Map;

/**
 *  OrderService
 *
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
public interface OrderService extends BaseService<Order> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 预约服务
     */
    void bookingService(OrderForm form);

    /**
     * 获取订单列表
     */
    List<OrderInfoBo> getOrderList(OrderForm form, Page page);


    List<OrderInfoBo> getMainPageOrderList(OrderForm form, Page page);

    /**
     * 确认订单
     * @param form
     */
    void confirmService(OrderForm form);

    /**
     * 查询订单详情
     */
    OrderInfoBo detail(String orderId);

    /**
     * 查询统计数据
     * @param openId
     * @return
     */
    SumBo getUserOrderCount(String openId);
}

