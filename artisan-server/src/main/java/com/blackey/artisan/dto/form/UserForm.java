package com.blackey.artisan.dto.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
@Getter
@Setter
public class UserForm implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;

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
	@NotBlank(message = "用户Openid 不能为空")
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

	private String code;

	private String encrypData;

	private String iv;

	private String wxSessionKey;

}
