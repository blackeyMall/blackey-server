package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求信息表 Form表单
 * 
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
public class RequirementForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private String id;
	/**
	 * 
	 */
    private Integer isDeleted;
	/**
	 * 
	 */
    private String createdBy;
	/**
	 * 
	 */
    private Date createdDate;
	/**
	 * 
	 */
    private String updatedBy;
	/**
	 * 
	 */
    private Date updatedDate;
	/**
	 * 需求名称
	 */
    private String titile;
	/**
	 * 需求内容
	 */
    private String content;
	/**
	 * 标签
	 */
    private String label;
	/**
	 * 点赞数量
	 */
    private Integer likeNum;
	/**
	 * 附件地址
	 */
    private String attachment;
	/**
	 * 关注数量
	 */
    private Integer followNum;
	/**
	 * 用户id
	 */
    private String userId;
	/**
	 * 认证状态
	 */
    private String auditStatus;
	/**
	 * 红包
	 */
    private String redPaper;
	/**
	 * 是否精品
	 */
    private String isRecommend;

}
