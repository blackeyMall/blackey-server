package com.blackey.admin.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysTenantMenu;

import java.util.Map;

/**
 * 租户菜单关联表 SysTenantMenuService
 *
 * @author kaven
 * @date 2018-12-22 14:33:05
 */
public interface SysTenantMenuService extends BaseService<SysTenantMenu> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

