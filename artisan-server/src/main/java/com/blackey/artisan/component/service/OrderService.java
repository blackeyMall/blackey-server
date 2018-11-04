package com.blackey.artisan.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.Order;

import java.util.Map;

/**
 *  OrderService
 *
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
public interface OrderService extends BaseService<Order> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

