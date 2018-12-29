package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统验证码
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_captcha")
public class SysCaptcha implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * uuid
	 */
	@TableId
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


    protected Serializable pkVal() {
        return this.getUuid();
    }
                

}
