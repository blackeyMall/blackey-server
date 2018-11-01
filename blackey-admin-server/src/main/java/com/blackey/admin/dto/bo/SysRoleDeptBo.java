package com.blackey.admin.dto.bo;

import java.io.Serializable;

/**
 * 角色与部门对应关系 BO
 * 
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
public class SysRoleDeptBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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
}
