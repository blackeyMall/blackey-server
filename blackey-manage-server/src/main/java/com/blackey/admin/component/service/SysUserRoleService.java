package com.blackey.admin.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系 SysUserRoleService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysUserRoleService extends BaseService<SysUserRole> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 删除用户角色关联
     * @param roleIds
     */
    void deleteBatch(String[] roleIds);

    /**
     * 保存用户和角色关联关系
     * @param userId
     * @param roleIdList
     */
    void saveOrUpdateUserRole(String userId, List<String> roleIdList);
}

