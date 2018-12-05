package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息表 BO
 * 
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Getter
@Setter
public class ProjectBo implements Serializable {

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
	 * 项目名称
	 */
    private String name;
	/**
	 * 项目简介
	 */
    private String brief;
	/**
	 * 项目logo
	 */
    private String logo;
	/**
	 * 点赞数量
	 */
    private Integer likeNum;
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
	 * 是否精品
	 */
    private String isRecommend;
	/**
	 * 标签
	 */
    private String label;
	/**
	 * 融资金额
	 */
    private String financeAmount;
	/**
	 * 融资阶段
	 */
    private String financeRound;

}