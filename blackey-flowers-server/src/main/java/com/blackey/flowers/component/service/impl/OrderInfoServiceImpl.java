package com.blackey.flowers.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.flowers.component.mapper.OrderInfoMapper;
import com.blackey.flowers.component.domain.OrderInfo;
import com.blackey.flowers.component.service.OrderInfoService;

import java.util.Map;

/**
 * 订单信息表 OrderInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Service
public class OrderInfoServiceImpl extends BaseServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderInfo> page = (Page<OrderInfo>) this.page(
                new Query<OrderInfo>(params).getPage(),
                new QueryWrapper<OrderInfo>()
        );

        return new PageUtils(page);
    }

}
