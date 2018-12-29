package com.blackey.admin.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统配置信息表 BO
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysConfigBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * key
	 */
    private String paramKey;
	/**
	 * value
	 */
    private String paramValue;
	/**
	 * 状态   0：隐藏   1：显示
	 */
    private Integer status;
	/**
	 * 备注
	 */
    private String remark;
	/**
	 * 租户ID
	 */
    private String tenantId;

}
