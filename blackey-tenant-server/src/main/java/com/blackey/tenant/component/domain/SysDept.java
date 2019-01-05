package com.blackey.tenant.component.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 部门管理
 *
 * @author kavenW
 * @date 2018-06-29 14:18:31
 */
@Getter
@Setter
@TableName("sys_dept")
public class SysDept extends BaseModel<SysDept> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long deptId;
	/**
	 * 上级部门ID，一级部门为0
	 */
	private Long parentId;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 是否删除  -1：已删除  0：正常
	 */
	private Integer delFlag;
	/**
	 * 租户id
	 */
	private Long tenantId;


}
