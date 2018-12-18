package com.blackey.admin.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统验证码 BO
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysCaptchaBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * uuid
	 */
    private String uuid;
	/**
	 * 验证码
	 */
    private String code;
	/**
	 * 过期时间
	 */
    private Date expireTime;
	/**
	 * 租户ID
	 */
    private String tenantId;

}
