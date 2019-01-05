package com.blackey.tenant.component.service.impl;

import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.tenant.component.domain.SysUserTokenEntity;
import com.blackey.tenant.component.mapper.SysUserTokenMapper;
import com.blackey.tenant.component.service.SysUserTokenService;
import com.blackey.tenant.global.shiro.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * token service
 * @author wangwei
 * @date 2018-03-08
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends BaseServiceImpl<SysUserTokenMapper, SysUserTokenEntity> implements SysUserTokenService {
	//12小时后过期
	private final static int EXPIRE = 3600 * 12;


	@Override
	public SysUserTokenEntity createToken(long userId) {
		String token = TokenGenerator.generateValue();

		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		SysUserTokenEntity tokenEntity = this.getById(userId);
		if(tokenEntity == null){
			tokenEntity = new SysUserTokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			this.save(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			this.updateById(tokenEntity);
		}

		return tokenEntity;
	}

	@Override
	public void logout(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();
		//修改token
		SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		this.updateById(tokenEntity);
	}
}
