package com.blackey.tenant.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.tenant.component.domain.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 * 
 * @author kavenW
 *
 * @date 2017-03-08 10:40:56
 */
public interface SysLogService extends BaseService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
