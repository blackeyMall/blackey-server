package com.blackey.finance.dto.bo;

import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.ProjectCategoryEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class ProjectInfoBo implements Serializable {

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
    private AuditStatusEnum auditStatus;
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
    private ProjectCategoryEnum category;
	/**
	 * 附件地址
	 */
	private String attachment;

    private Date createdDate;
	/**
	 * 是否关注标示，add 关注 cancel 未关注
	 */
	private AddCancelEnum isFollow = AddCancelEnum.CANCEL;
	/**
	 * 是否关注标示，add 关注 cancel 未关注
	 */
	private AddCancelEnum isLike = AddCancelEnum.CANCEL;

	/**
	 * 姓名
	 */
	private String userName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 职位
	 */
	private String duties;
	/**
	 * 微信头像
	 */
	private String avatarUrl;

	/**
	 * 项目网址
	 */
	private String websiteUrl;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 项目领域
	 */
	private String projectDomain;
	/**
	 * 项目描述
	 */
	private String projectDesc;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 所属行业
	 */
	private String industry;

	/**
	 * 图片链接
	 */
	private String[] images;




}
