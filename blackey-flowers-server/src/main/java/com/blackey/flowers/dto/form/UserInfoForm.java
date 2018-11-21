package com.blackey.flowers.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表 Form表单
 * 
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
public class UserInfoForm implements Serializable {

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
