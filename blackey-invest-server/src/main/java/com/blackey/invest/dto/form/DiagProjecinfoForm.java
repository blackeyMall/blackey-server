package com.blackey.invest.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息表 Form表单
 * 
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@Getter
@Setter
public class DiagProjecinfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    private Long id;
	/**
	 * 项目编号
	 */
    private String projectNo;
	/**
	 * 项目名称
	 */
    private String projectName;
	/**
	 * 项目简介
	 */
    private String projectBrief;
	/**
	 * 创业者姓名
	 */
    private String entrepreneur;
	/**
	 * 项目详细描述
	 */
    private String projectDesc;
	/**
	 * 微信openid
	 */
    private String openid;
	/**
	 * 手机号
	 */
    private String mobile;
	/**
	 * 项目状态（1待审核、2审核通过、3审核拒绝）
	 */
    private Integer status;
	/**
	 * 邮箱
	 */
    private String email;
	/**
	 * 项目套餐编号
	 */
    private String setmeetNo;
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
