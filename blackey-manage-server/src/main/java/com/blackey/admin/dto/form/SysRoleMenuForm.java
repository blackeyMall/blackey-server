package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色与菜单对应关系 Form表单
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysRoleMenuForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
    private String roleId;
	/**
	 * 菜单ID
	 */
    private String menuId;

}
