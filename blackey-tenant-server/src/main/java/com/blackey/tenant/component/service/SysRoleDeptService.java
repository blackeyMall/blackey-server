package com.blackey.tenant.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.tenant.component.domain.SysRoleDept;

import java.util.List;


/**
 * 角色与部门对应关系 SysRoleDeptService
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
public interface SysRoleDeptService extends BaseService<SysRoleDept> {


    void saveOrUpdate(Long roleId, List<Long> deptIdList);

    /**
     * 根据角色ID，获取部门ID列表
     */
    List<Long> queryDeptIdList(Long[] roleIds) ;

    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(Long[] roleIds);
}

