package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户好友关联表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserRelationBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
	/**
	 * 申请状态（通过，拒绝，待同意）
	 */
    private String status;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 微信号
	 */
	private String wechatNo;
	/**
	 * 微信头像
	 */
	private String avatarUrl;
	/**
	 * openid
	 */
	private String openId;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 职位
	 */
	private String duties;
	/**
	 * 公司简介
	 */
	private String companyBrief;
	/**
	 * 公司官网
	 */
	private String companyWebsite;
	/**
	 * 公司地址
	 */
	private String companyAddress;
	/**
	 * 名片图片地址
	 */
	private String visitingAcrd;
	/**
	 * 是否实名认证
	 */
	private String isIdentity;
	/**
	 * 姓名
	 */
	private String name;

	private int isFocus;
}
