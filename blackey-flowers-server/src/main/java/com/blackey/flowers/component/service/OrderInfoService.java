package com.blackey.flowers.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.OrderInfo;

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
}

