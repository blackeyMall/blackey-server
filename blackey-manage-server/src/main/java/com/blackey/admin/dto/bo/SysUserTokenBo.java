package com.blackey.admin.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户Token BO
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysUserTokenBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private String userId;
	/**
	 * token
	 */
    private String token;
	/**
	 * 过期时间
	 */
    private Date expireTime;
	/**
	 * 更新时间
	 */
    private Date updateTime;

}
