package com.blackey.admin.component.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;

import java.io.Serializable;

/**
 * 部门管理
 *
 * @author kavenW
 * @date 2018-06-29 14:18:31
 */
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
	 * set：
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * get：
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * set：上级部门ID，一级部门为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * get：上级部门ID，一级部门为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * set：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get：部门名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * set：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * get：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * set：是否删除  -1：已删除  0：正常
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * get：是否删除  -1：已删除  0：正常
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }

}
