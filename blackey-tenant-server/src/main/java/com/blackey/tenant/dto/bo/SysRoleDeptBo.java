package com.blackey.tenant.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 角色与部门对应关系 BO
 * 
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@Setter
@Getter
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

}
