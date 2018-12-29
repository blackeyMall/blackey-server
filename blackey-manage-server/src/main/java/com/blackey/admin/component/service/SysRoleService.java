package com.blackey.admin.component.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.admin.dto.form.SysRoleForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysRole;

import java.util.List;
import java.util.Map;

/**
 * 角色 SysRoleService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 创建角色
     * @param role
     */
    void saveRole(SysRole role);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(SysRole role);

    /**
     * 批量删除角色
     * @param roleIds
     */
    void deleteBatch(String[] roleIds);


    /**
     * 查询用户创建的角色ID列表
     * @param createUserId
     * @return
     */
    List<String> queryRoleIdList(String createUserId);

    /**
     * 分页查询
     * @param sysRoleForm
     * @param page
     * @return
     */
    IPage<SysRole> queryPage(SysRoleForm sysRoleForm, IPage<SysRole> page);
}

