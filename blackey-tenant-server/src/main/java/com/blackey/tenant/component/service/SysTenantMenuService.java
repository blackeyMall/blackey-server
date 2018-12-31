package com.blackey.tenant.component.service;

import com.blackey.tenant.component.domain.SysMenuEntity;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.tenant.component.domain.SysTenantMenu;

import java.util.List;
import java.util.Map;

/**
 * 租户菜单关联表 SysTenantMenuService
 *
 * @author kaven
 * @date 2018-12-22 14:33:05
 */
public interface SysTenantMenuService extends BaseService<SysTenantMenu> {

    /**
     * 根据角色ID，获取菜单ID列表
     * @param tenantId
     * @return
     */
    List<SysMenuEntity> queryMenuListByTenantId(Long tenantId);
    /**
     * 保存/更新租户菜单
     * @param tenantId
     * @param menuList
     */
    void saveOrUpdateTenantMenu(Long tenantId, List<Long> menuList);

    /**
     * 查询菜单id
     * @param id
     * @return
     */
    List<Long>  queryMenuIdByTenantId(Long id);
}

