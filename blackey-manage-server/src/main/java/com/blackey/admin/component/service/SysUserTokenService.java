package com.blackey.admin.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysUserToken;

import java.util.Map;

/**
 * 系统用户Token SysUserTokenService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysUserTokenService extends BaseService<SysUserToken> {

    /**
     * 生成token
     * @param userId  用户ID
     */
    SysUserToken createToken(String userId);

    /**
     * 退出，修改token值
     * @param userId  用户ID
     */
    void logout(String userId);

}

