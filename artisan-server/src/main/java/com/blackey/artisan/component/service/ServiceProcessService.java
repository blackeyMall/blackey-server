package com.blackey.artisan.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.ServiceProcess;

import java.util.Map;

/**
 *  ServiceProcessService
 *
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */
public interface ServiceProcessService extends BaseService<ServiceProcess> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

