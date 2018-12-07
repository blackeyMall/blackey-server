package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注用户表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserPersonFollowForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
    private String openId;
	/**
	 * 被关注人id
	 */
    private String personId;
	/**
	 * 备注
	 */
    private String remark;

}
