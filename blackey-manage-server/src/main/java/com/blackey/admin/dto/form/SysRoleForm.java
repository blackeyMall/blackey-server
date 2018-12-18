package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色 Form表单
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysRoleForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 角色名称
	 */
    private String roleName;
	/**
	 * 备注
	 */
    private String remark;
	/**
	 * 租户ID
	 */
    private String tenantId;

}
