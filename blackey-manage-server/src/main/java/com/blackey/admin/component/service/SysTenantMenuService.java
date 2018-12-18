package com.blackey.admin.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysTenantMenu;

import java.util.Map;

/**
 *  SysTenantMenuService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysTenantMenuService extends BaseService<SysTenantMenu> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

