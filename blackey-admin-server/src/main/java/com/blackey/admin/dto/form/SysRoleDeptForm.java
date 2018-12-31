package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 角色与部门对应关系 Form表单
 * 
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@Setter
@Getter
public class SysRoleDeptForm implements Serializable {

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


}
