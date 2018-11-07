package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.ServiceProcessMapper;
import com.blackey.artisan.component.domain.ServiceProcess;
import com.blackey.artisan.component.service.ServiceProcessService;

import java.util.Map;

/**
 *  ServiceProcessServiceImpl
 *
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */
@Service
public class ServiceProcessServiceImpl extends BaseServiceImpl<ServiceProcessMapper, ServiceProcess> implements ServiceProcessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProcessServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ServiceProcess> page = (Page<ServiceProcess>) this.page(
                new Query<ServiceProcess>(params).getPage(),
                new QueryWrapper<ServiceProcess>()
        );

        return new PageUtils(page);
    }

}
