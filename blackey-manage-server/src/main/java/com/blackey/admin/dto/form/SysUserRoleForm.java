package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户与角色对应关系 Form表单
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysUserRoleForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
    private String userId;
	/**
	 * 角色ID
	 */
    private String roleId;

}
