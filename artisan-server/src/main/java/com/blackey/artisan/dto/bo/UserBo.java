package com.blackey.artisan.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:23
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
	private String sexDesc;
	/**
	 *
	 */
	private Long subscribeTime;
	/**
	 *
	 */
	private String uniqueId;


	private String nickName;

	private String gender;

	private String telephone;

}
