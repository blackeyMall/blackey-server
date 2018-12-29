package com.blackey.admin.component.service;


import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.domain.SysUserToken;

import java.util.Set;

/**
 * shiro相关接口
 * @author kavenW
 *
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(String userId);

    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUser queryUser(String userId);
}
