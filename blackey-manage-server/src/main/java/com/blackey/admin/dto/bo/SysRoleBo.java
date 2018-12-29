package com.blackey.admin.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色 BO
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysRoleBo implements Serializable {

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
