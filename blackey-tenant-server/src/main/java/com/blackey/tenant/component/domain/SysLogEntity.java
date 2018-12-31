package com.blackey.tenant.component.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统日志
 * 
 * @author kavenW
 *
 * @date 2017-03-08 10:40:56
 */
@Getter
@Setter
@TableName("sys_log")
public class SysLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId
	private Long id;
	//用户名
	private String username;
	//用户操作
	private String operation;
	//请求方法
	private String method;
	//请求参数
	private String params;
	//执行时长(毫秒)
	private Long time;
	//IP地址
	private String ip;
	//创建时间
	private Date createDate;
	/**
	 * 租户id
	 */
	private Long tenantId;

}
