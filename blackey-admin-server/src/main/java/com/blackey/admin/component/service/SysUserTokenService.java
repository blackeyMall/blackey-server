package com.blackey.admin.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.admin.component.domain.SysUserTokenEntity;

/**
 * 用户Token
 * 
 * @author kavenW
 *
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService extends BaseService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
    SysUserTokenEntity createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
