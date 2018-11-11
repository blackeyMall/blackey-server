package com.blackey.artisan.component.service.impl;

import com.blackey.artisan.dto.bo.ServiceInfoBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.ServiceInfoMapper;
import com.blackey.artisan.component.domain.ServiceInfo;
import com.blackey.artisan.component.service.ServiceInfoService;

import javax.annotation.Resource;
import java.util.Map;

/**
 *  ServiceInfoServiceImpl
 *
 * @author kavenW
 * @date 2018-11-06 13:45:21
 */
@Service
public class ServiceInfoServiceImpl extends BaseServiceImpl<ServiceInfoMapper, ServiceInfo> implements ServiceInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInfoServiceImpl.class);


    @Resource
    private ServiceInfoMapper serviceInfoMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ServiceInfo> page = (Page<ServiceInfo>) this.page(
                new Query<ServiceInfo>(params).getPage(),
                new QueryWrapper<ServiceInfo>()
        );

        return new PageUtils(page);
    }


    @Override
    public ServiceInfoBo queryByOrderId(String orderId) {
        return serviceInfoMapper.queryByOrderId(orderId);
    }
}
