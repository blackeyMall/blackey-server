package com.blackey.tenant.component.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_tenant_menu")
public class SysTenantMenu implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	/**
	 * 租户id
	 */
	private Long tenantId;
	/**
	 * 菜单id
	 */
	private Long menuId;

	@TableField(fill = FieldFill.INSERT)
	private Date createdDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updatedDate;

	@TableField(fill = FieldFill.INSERT)
	private String createdBy;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updatedBy;


}
