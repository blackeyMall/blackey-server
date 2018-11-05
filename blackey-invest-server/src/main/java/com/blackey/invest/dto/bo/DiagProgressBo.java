package com.blackey.invest.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目进展表 BO
 * 
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@Getter
@Setter
public class DiagProgressBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    private Long id;
	/**
	 * 项目进展编号
	 */
    private String progressNo;
	/**
	 * 项目编号
	 */
    private String projectNo;
	/**
	 * 项目进展描述
	 */
    private String progressDesc;
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
