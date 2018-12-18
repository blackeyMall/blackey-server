package com.blackey.admin.rest;


import com.blackey.admin.component.domain.SysUser;
import com.blackey.common.rest.BaseRest;
import org.apache.shiro.SecurityUtils;

/**
 * Controller公共组件
 * 
 * @author kavenW
 *
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController extends BaseRest {

	protected SysUser getUser() {
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}

	protected String getUserId() {
		return getUser().getId();
	}

	protected String getTenangtId() {
		return getUser().getTenantId();
	}
}
