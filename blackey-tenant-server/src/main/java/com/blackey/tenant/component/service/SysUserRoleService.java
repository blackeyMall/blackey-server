package com.blackey.tenant.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.tenant.component.domain.SysUserRoleEntity;

import java.util.List;


/**
 * 用户与角色对应关系
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:43:24
 */
public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {
	
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
