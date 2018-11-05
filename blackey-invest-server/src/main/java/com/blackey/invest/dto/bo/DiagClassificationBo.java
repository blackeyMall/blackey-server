package com.blackey.invest.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目分类 BO
 * 
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
public class DiagClassificationBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private Integer id;
	/**
	 * 分类编号
	 */
    private String classNo;
	/**
	 * 分类名称
	 */
    private String className;
	/**
	 * 分类描述
	 */
    private String classDesc;
	/**
	 * 上级分类ID，一级分类为0
	 */
    private Long parentId;
	/**
	 * 排序
	 */
    private Integer orderNum;
	/**
	 * 逻辑删除
	 */
    private Integer isDeleted;
	/**
	 * 创建人
	 */
    private String createBy;
	/**
	 * 创建时间
	 */
    private Date createDate;
	/**
	 * 更新人
	 */
    private String updateBy;
	/**
	 * 更新时间
	 */
    private Date updateDate;

}
