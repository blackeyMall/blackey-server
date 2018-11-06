package com.blackey.artisan.component.service.impl;

import com.blackey.artisan.component.domain.Project;
import com.blackey.artisan.component.domain.ServiceInfo;
import com.blackey.artisan.component.domain.User;
import com.blackey.artisan.component.service.ProjectService;
import com.blackey.artisan.component.service.ServiceInfoService;
import com.blackey.artisan.component.service.UserService;
import com.blackey.artisan.dto.bo.OrderInfoBo;
import com.blackey.artisan.dto.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.OrderMapper;
import com.blackey.artisan.component.domain.Order;
import com.blackey.artisan.component.service.OrderService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 *  OrderServiceImpl
 *
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private UserService userService;

    @Resource
    private ProjectService projectService;

    @Resource
    private ServiceInfoService serviceInfoService;

    @Resource
    private OrderMapper orderMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Order> page = (Page<Order>) this.page(
                new Query<Order>(params).getPage(),
                new QueryWrapper<Order>()
        );

        return new PageUtils(page);
    }

    @Override
    public void bookingService(OrderForm form) {
        User user = userService.getById(form.getUserId());
        Project project = projectService.getById(form.getProjectId());

        ServiceInfo serviceInfo = new ServiceInfo();
        BeanUtils.copyProperties(form,serviceInfo);
        serviceInfoService.save(serviceInfo);

        if (Optional.ofNullable(user).isPresent() && Optional.ofNullable(project).isPresent()){
            Order order = new Order();
            //Form --> domain
            BeanUtils.copyProperties(form,order);
            order.setOrderNo(System.currentTimeMillis() + "" +new Random().nextInt());
            order.setServiceNo(serviceInfo.getId());
            this.save(order);
        }
    }

    @Override
    public List<OrderInfoBo> getMainPageOrderList(OrderForm form) {
        return orderMapper.getMainPageOrderList(form);
    }
}
