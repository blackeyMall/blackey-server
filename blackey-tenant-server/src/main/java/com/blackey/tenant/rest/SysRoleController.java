package com.blackey.tenant.rest;

import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.tenant.component.domain.SysRoleEntity;
import com.blackey.tenant.component.service.SysRoleMenuService;
import com.blackey.tenant.component.service.SysRoleService;
import com.blackey.tenant.global.constants.RoleEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 * 
 * @author kavenW
 * @date 2016年11月8日 下午2:18:33
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	/**
	 * 角色列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:role:list")
	public Result list(@RequestParam Map<String, Object> params){
		//如果不是超级管理员，则只查询自己创建的角色列表
		if(getUser().getRoleType() == RoleEnum.ROLE_USER.getCode()
				|| getUser().getRoleType() == RoleEnum.ROLE_VISITOR.getCode()){
			params.put("createUserId", getUserId());
		}
		//租户管理员，可以看到该租户下所有的角色
		if(getUser().getRoleType() == RoleEnum.ROLE_ADMIN.getCode()){
			params.put("tenantId", getTenangtId());
		}

		PageUtils page = sysRoleService.queryPage(params);

		return success(page);
	}
	
	/**
	 * 角色列表
	 */
	@GetMapping("/select")
	@RequiresPermissions("sys:role:select")
	public Result select(){
		Map<String, Object> map = new HashMap<>();
		
		//用户和游客，只查询自己所拥有的角色列表
		if(getUser().getRoleType() == RoleEnum.ROLE_USER.getCode()
				|| getUser().getRoleType() == RoleEnum.ROLE_VISITOR.getCode()){
			map.put("create_user_id", getUserId());
		}
		//租户管理员，可以看到该租户下所有的角色
		if(getUser().getRoleType() == RoleEnum.ROLE_ADMIN.getCode()){
			map.put("tenant_id", getTenangtId());
		}
		List<SysRoleEntity> list = (List<SysRoleEntity>) sysRoleService.listByMap(map);
		
		return success(list);
	}
	
	/**
	 * 角色信息
	 */
	@GetMapping("/info/{roleId}")
	@RequiresPermissions("sys:role:info")
	public Result info(@PathVariable("roleId") Long roleId){
		SysRoleEntity role = sysRoleService.getById(roleId);
		
		//查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
		role.setMenuIdList(menuIdList);
		
		return success(role);
	}
	
	/**
	 * 保存角色
	 */
	@PostMapping("/save")
	@RequiresPermissions("sys:role:save")
	public Result save(@RequestBody SysRoleEntity role){

		role.setCreateUserId(getUserId());
		role.setTenantId(getTenangtId());
		sysRoleService.saveRole(role);
		
		return success();
	}
	
	/**
	 * 修改角色
	 */
	@PostMapping("/update")
	@RequiresPermissions("sys:role:update")
	public Result update(@RequestBody SysRoleEntity role){

		role.setCreateUserId(getUserId());
		role.setTenantId(getTenangtId());
		sysRoleService.updateRole(role);
		
		return success();
	}
	
	/**
	 * 删除角色
	 */
	@PostMapping("/delete")
	@RequiresPermissions("sys:role:delete")
	public Result delete(@RequestBody Long[] roleIds){
		sysRoleService.deleteBatch(roleIds);
		
		return success();
	}
}
