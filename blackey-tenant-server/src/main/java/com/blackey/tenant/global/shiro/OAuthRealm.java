package com.blackey.tenant.global.shiro;

import com.blackey.common.result.ResultCodeEnum;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.component.domain.SysUserTokenEntity;
import com.blackey.tenant.component.service.ShiroService;
import com.blackey.tenant.global.constants.StatusEnum;
import com.blackey.tenant.global.constants.TenantResultEnum;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 认证 realm
 * @author wangwei
 * @date  2018/6/4
 */
@Component
public class OAuthRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(OAuthRealm.class);
    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuthToken;
    }


    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        //Long userId = user.getUserId();

        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(user);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        LOGGER.info("---init doGetAuthorizationInfo {}---",info);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()"+accessToken);
        //根据accessToken，查询用户信息
        SysUserTokenEntity tokenEntity = shiroService.queryByToken(accessToken);
        //token失效
        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException(ResultCodeEnum.TOKEN_TIMEOUT_ERROR.getMsg());
        }

        //查询用户信息
        SysUserEntity user = shiroService.queryUser(tokenEntity.getUserId());
        //账号锁定
        if(user.getStatus() == StatusEnum.SATUS_DISABLE.getCode()){
            throw new LockedAccountException(TenantResultEnum.USER_UNENABLE_ERROR.getMsg());
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        LOGGER.info("---init doGetAuthorizationInfo {}---",info);
        return info;
    }
}
