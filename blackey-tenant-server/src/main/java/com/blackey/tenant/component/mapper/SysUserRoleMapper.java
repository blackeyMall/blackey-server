package com.blackey.tenant.component.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.tenant.component.domain.SysUserRoleEntity;


import java.util.List;

/**
 * 用户与角色对应关系
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:34:46
 */

public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);


	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
