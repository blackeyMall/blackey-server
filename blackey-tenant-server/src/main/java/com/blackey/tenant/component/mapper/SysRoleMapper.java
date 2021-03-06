package com.blackey.tenant.component.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.tenant.component.domain.SysRoleEntity;


import java.util.List;

/**
 * 角色管理
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:33:33
 */

public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
