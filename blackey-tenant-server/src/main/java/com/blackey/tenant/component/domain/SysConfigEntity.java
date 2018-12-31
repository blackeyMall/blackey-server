package com.blackey.tenant.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统配置信息
 * 
 * @author kavenW
 *
 * @date 2016年12月4日 下午6:43:36
 */
@Getter
@Setter
@TableName("sys_config")
public class SysConfigEntity {
	@TableId
	private Long id;
	private String paramKey;
	private String paramValue;
	private String remark;
	/**
	 * 租户id
	 */
	private Long tenantId;

}
