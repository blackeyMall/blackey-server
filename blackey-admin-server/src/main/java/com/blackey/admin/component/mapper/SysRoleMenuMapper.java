package com.blackey.admin.component.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.admin.component.domain.SysRoleMenuEntity;


import java.util.List;

/**
 * 角色与菜单对应关系
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:33:46
 */

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
