package com.blackey.admin.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 数据字典表 BO
 * 
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@Setter
@Getter
public class SysDictBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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

}
