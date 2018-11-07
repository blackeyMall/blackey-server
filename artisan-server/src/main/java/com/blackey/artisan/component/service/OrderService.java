package com.blackey.artisan.component.service;

import com.blackey.artisan.dto.bo.OrderInfoBo;
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
    List<OrderInfoBo> getMainPageOrderList(OrderForm form);


}

