package com.blackey.admin.component.service;

import com.blackey.admin.component.domain.SysUserEntity;
import com.blackey.mybatis.service.BaseService;
import com.blackey.admin.component.domain.SysMenuEntity;

import java.util.List;


/**
 * 菜单管理
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:42:16
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 */
	List<SysMenuEntity> getUserMenuList(SysUserEntity sysUserEntity);

	/**
	 * 删除
	 */
	void delete(Long menuId);

	/**
	 * 根据租户id查询菜单列表
	 * @param tenantId
	 * @return
	 */
	List<SysMenuEntity> queryMenuByTenantId(Long tenantId);
}
