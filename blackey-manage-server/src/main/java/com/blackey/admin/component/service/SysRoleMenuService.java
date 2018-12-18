package com.blackey.admin.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysRoleMenu;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系 SysRoleMenuService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenu> {

    /**
     * 保存菜单角色
     * @param roleId
     * @param menuIdList
     */
    void saveOrUpdate(String roleId, List<String> menuIdList);

    /**
     * 根据角色ID，获取菜单ID列表
     * @param roleId
     * @return
     */
    List<String> queryMenuIdListByRoleId(String roleId);

    /**
     * 根据角色ID数组，批量删除
     * @param roleIds
     * @return
     */
    int deleteBatch(String[] roleIds);

}

