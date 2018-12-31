package com.blackey.admin.component.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 数据字典表
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@TableName("sys_dict")
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 字典名称
	 */
	private String name;
	/**
	 * 字典类型
	 */
	private String type;
	/**
	 * 字典码
	 */
	private String code;
	/**
	 * 字典值
	 */
	private String value;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 删除标记  -1：已删除  0：正常
	 */
	private Integer delFlag;
	/**
	 * set：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * get：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * set：字典名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get：字典名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * set：字典类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * get：字典类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * set：字典码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * get：字典码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * set：字典值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * get：字典值
	 */
	public String getValue() {
		return value;
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
	 * set：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * get：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * set：删除标记  -1：已删除  0：正常
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * get：删除标记  -1：已删除  0：正常
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

}
