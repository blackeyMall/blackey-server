package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表 BO
 * 
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
public class UserBo implements Serializable {

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
    private Integer wechatNo;
	/**
	 * 微信头像
	 */
    private String avatarUrl;
	/**
	 * openid
	 */
    private Integer openId;
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

}
