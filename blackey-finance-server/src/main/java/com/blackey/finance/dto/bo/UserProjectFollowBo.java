package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注项目表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserProjectFollowBo implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;
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
	private String openId;
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
	/**
	 * 类别
	 */
	private String category;

	private Date createdDate;
	/**
	 * 备注
	 */
    private String remark;

	/**
	 * 姓名
	 */
	private String userName;
	/**
	 * 性别
	 */
	private String sex;

}
