package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 部门管理 Form表单
 * 
 * @author kavenW
 * @date 2018-06-29 14:18:31
 */
@Setter
@Getter
public class SysDeptForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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

}
