package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信用户信息表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 13:53:50
 */
@Getter
@Setter
public class WechatUserInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private String city;
	/**
	 * 
	 */
    private String country;
	/**
	 * 
	 */
    private Integer groupId;
	/**
	 * 
	 */
    private String avatarUrl;
	/**
	 * 
	 */
    private String language;
	/**
	 * 
	 */
    private String nickName;
	/**
	 * 
	 */
    private String openId;
	/**
	 * 
	 */
    private String province;
	/**
	 * 
	 */
    private String remark;
	/**
	 * 
	 */
    private Integer gender;
	/**
	 * 
	 */
    private String sexDesc;
	/**
	 * 
	 */
    private Long subscribeTime;
	/**
	 * 
	 */
    private String uniqueId;
	/**
	 * 
	 */
    private String telephone;

}
