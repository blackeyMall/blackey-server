package com.blackey.tenant.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.tenant.component.domain.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:42:52
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {
	/**
	 * 分页查询角色信息
	 * @param params
	 * @return
	 */
	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 创建角色信息
	 * @param role
	 */
	void saveRole(SysRoleEntity role);
	/**
	 * 更新角色信息
	 * @param role
	 */
	void updateRole(SysRoleEntity role);
	/**
	 * 删除角色信息
	 * @param roleIds
	 */
	void deleteBatch(Long[] roleIds);
	/**
	 * 查询用户创建的角色ID列表
	 * @param createUserId
	 * @return
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
