package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户信息表
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
@TableName("t_user_info")
public class UserInfo extends BaseModel<UserInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

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
	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 邮箱已认证
	 */
	private Boolean emailConfirm;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }


}
