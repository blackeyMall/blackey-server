package com.blackey.invest.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员审核记录信息 Form表单
 * 
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
public class DiagAudirecordForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private Integer id;
	/**
	 * 审核记录编号
	 */
    private String recordNo;
	/**
	 * 审核状态2审核通过、3审核拒绝
	 */
    private Integer recordStatus;
	/**
	 * 项目编号
	 */
    private String projectNo;
	/**
	 * 审核描述
	 */
    private String recordDesc;
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
