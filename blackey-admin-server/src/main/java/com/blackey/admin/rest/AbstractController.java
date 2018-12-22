package com.blackey.admin.rest;


import com.blackey.admin.component.domain.SysUserEntity;
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

	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getTenangtId() {
		return getUser().getTenantId();
	}
}
