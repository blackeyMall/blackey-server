package com.blackey.artisan.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.ServiceInfo;

import java.util.Map;

/**
 *  ServiceInfoService
 *
 * @author kavenW
 * @date 2018-11-06 13:45:21
 */
public interface ServiceInfoService extends BaseService<ServiceInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

