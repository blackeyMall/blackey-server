package com.blackey.admin.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysLog;

import java.util.Map;

/**
 * 系统日志 SysLogService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysLogService extends BaseService<SysLog> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

