package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注用户表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserPersonFollowBo implements Serializable {

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
