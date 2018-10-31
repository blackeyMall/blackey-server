package com.blackey.component.service.impl;

import com.blackey.component.model.OrderInfo;
import com.blackey.component.repository.OrderRepository;
import com.blackey.component.service.OrderInfoService;
import com.blackey.jpa.repo.BaseRepository;
import com.blackey.jpa.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author blackey
 * @date 2018/10/31
 */
@Service
public class OrderInfoServiceImpl extends BaseServiceImpl<OrderInfo> implements OrderInfoService{

    private OrderRepository orderRepository;

    @Override
    protected BaseRepository<OrderInfo> getRepo() {
        return orderRepository;
    }
}
