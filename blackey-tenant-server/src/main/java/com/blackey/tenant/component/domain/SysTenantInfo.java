package com.blackey.tenant.component.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 租户信息
 *
 * @author kaven
 * @date 2018-12-12 11:23:05
 */
@Getter
@Setter
@TableName("sys_tenant_info")
public class SysTenantInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 法人姓名
	 */
	private String legalPerson;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 职位
	 */
	private String duties;
	/**
	 * 公司简介
	 */
	private String companyBrief;
	/**
	 * 公司官网
	 */
	private String companyWebsite;
	/**
	 * 公司地址
	 */
	private String companyAddress;
	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;

	@TableField(fill = FieldFill.INSERT)
	private Date createdDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updatedDate;

	@TableField(fill = FieldFill.INSERT)
	private String createdBy;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updatedBy;

	/**
	 * 菜单信息
	 */
	@TableField(exist = false)
	private List<Long> menuIdList;
	/**
	 * 用户名
	 */
	@TableField(exist = false)
	private String userName;



}
