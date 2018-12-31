package com.blackey.admin.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysTenantMenuBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
    private String tenantId;
	/**
	 * 菜单id
	 */
    private String menuId;

}
