package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 角色与部门对应关系
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@TableName("sys_role_dept")
public class SysRoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 部门ID
	 */
	private Long deptId;
	/**
	 * 租户id
	 */
	private Long tenantId;

	/**
	 * set：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * get：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * set：角色ID
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * get：角色ID
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * set：部门ID
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * get：部门ID
	 */
	public Long getDeptId() {
		return deptId;
	}


	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
}
