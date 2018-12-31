package com.blackey.admin.component.service.impl;

import com.blackey.admin.component.domain.SysMenu;
import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.domain.SysUserToken;
import com.blackey.admin.component.mapper.SysMenuMapper;
import com.blackey.admin.component.mapper.SysUserMapper;
import com.blackey.admin.component.mapper.SysUserTokenMapper;
import com.blackey.admin.component.service.ShiroService;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.admin.global.constants.StatusEnum;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * ShiroServiceImpl 权限
 * @author wangwei
 * @date 2018-12-18
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    SysMenuMapper sysMenuMapper;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserTokenMapper sysUserTokenMapper;

    @Override
    public Set<String> getUserPermissions(String userId) {
        List<String> permsList;

        SysUser sysUser = sysUserMapper.selectById(userId);
        if(null == sysUser){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        if(StatusEnum.SATUS_DISABLE.getCode() == sysUser.getStatus()){
            throw new BusinessException("用户被禁用");
        }
        //系统管理员，拥有最高权限
        if(sysUser.getRoleType() == RoleEnum.ROLE_SUPER.getCode()){
            List<SysMenu> menuList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserMapper.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUser queryUser(String userId) {
        return sysUserMapper.selectById(userId);
    }
}
