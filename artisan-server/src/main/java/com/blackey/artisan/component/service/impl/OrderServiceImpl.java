package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.OrderMapper;
import com.blackey.artisan.component.domain.Order;
import com.blackey.artisan.component.service.OrderService;

import java.util.Map;

/**
 *  OrderServiceImpl
 *
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Order> page = (Page<Order>) this.page(
                new Query<Order>(params).getPage(),
                new QueryWrapper<Order>()
        );

        return new PageUtils(page);
    }

}
