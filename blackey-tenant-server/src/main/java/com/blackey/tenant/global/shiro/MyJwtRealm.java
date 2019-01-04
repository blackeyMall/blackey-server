package com.blackey.tenant.global.shiro;

import com.blackey.common.exception.BaseException;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.exception.UnauthorizedException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.component.service.ShiroService;
import com.blackey.tenant.component.service.SysUserService;
import com.blackey.tenant.dto.form.JWTInfoForm;
import com.blackey.tenant.global.constants.StatusEnum;
import com.blackey.tenant.global.constants.TenantResultEnum;
import com.blackey.tenant.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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
public class MyJwtRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyJwtRealm.class);
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }


    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println(principals.getPrimaryPrincipal()+"======");
        SysUserEntity userEntity = (SysUserEntity)principals.getPrimaryPrincipal();
        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(userEntity);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        LOGGER.info("---init doGetAuthorizationInfo {}---",info);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws BaseException {
        String accessToken = (String) token.getPrincipal();

        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()"+accessToken);

        String username = JWTUtil.getUsername(accessToken);
        if (username == null) {
            throw new UnauthorizedException(ResultCodeEnum.UNAUTHORIZED);
        }
        SysUserEntity user = sysUserService.queryByUserName(username);
        if (user == null) {
            throw new UnauthorizedException(ResultCodeEnum.UNAUTHORIZED);
        }
        //账号锁定
        if(user.getStatus() == StatusEnum.SATUS_DISABLE.getCode()){
            throw new BusinessException(TenantResultEnum.USER_UNENABLE_ERROR);
        }

        JWTInfoForm jwtInfoForm = new JWTInfoForm();
        jwtInfoForm.setUserId(String.valueOf(user.getUserId()));
        jwtInfoForm.setUserName(username);
        jwtInfoForm.setSecret(user.getPassword());
        if (JWTUtil.verifyToken(accessToken, jwtInfoForm).getCode() != ResultCodeEnum.SUCCESS.getCode()) {
            throw new UnauthorizedException(ResultCodeEnum.UNAUTHORIZED);
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        LOGGER.info("---init doGetAuthorizationInfo {}---",info);
        return info;
    }
}
