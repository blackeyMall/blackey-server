package com.blackey.artisan.dto.form;

import lombok.Getter;
import lombok.Setter;

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

	private String nickName;

	private String province;

	private String city;

	private String gender;

	private String country;

	private String avatarUrl;

	private String telephone;

	private String openId;

	private String uniqueId;

	private String code;

	private String encrypData;

	private String iv;

}
