package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志 Form表单
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysLogForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
    private String username;
	/**
	 * 用户操作
	 */
    private String operation;
	/**
	 * 请求方法
	 */
    private String method;
	/**
	 * 请求参数
	 */
    private String params;
	/**
	 * 执行时长(毫秒)
	 */
    private Long time;
	/**
	 * IP地址
	 */
    private String ip;

}
