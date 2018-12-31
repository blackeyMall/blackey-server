package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传 Form表单
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysOssForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * URL地址
	 */
    private String url;
	/**
	 * 创建时间
	 */
    private Date createDate;
	/**
	 * 租户ID
	 */
    private String tenantId;

}
