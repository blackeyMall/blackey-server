package com.blackey.tenant.rest;


import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.common.rest.BaseRest;
import com.blackey.tenant.component.service.SysUserService;
import com.blackey.tenant.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller公共组件
 * 
 * @author kavenW
 *
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController extends BaseRest {

	@Autowired
	SysUserService sysUserService;

	protected SysUserEntity getUser() {

		SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		return sysUserEntity;
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getTenangtId() {
		return getUser().getTenantId();
	}
}
