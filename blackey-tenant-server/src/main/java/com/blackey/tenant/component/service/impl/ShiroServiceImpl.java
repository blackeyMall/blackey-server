package com.blackey.tenant.component.service.impl;

import com.blackey.tenant.component.domain.SysMenuEntity;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.component.domain.SysUserTokenEntity;
import com.blackey.tenant.component.mapper.SysMenuMapper;
import com.blackey.tenant.component.mapper.SysUserMapper;
import com.blackey.tenant.component.mapper.SysUserTokenMapper;
import com.blackey.tenant.component.service.ShiroService;
import com.blackey.tenant.global.constants.RoleEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserTokenMapper sysUserTokenMapper;

    @Override
    public Set<String> getUserPermissions(SysUserEntity sysUserEntity) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(sysUserEntity.getRoleType() == RoleEnum.ROLE_SUPER.getCode()){
            List<SysMenuEntity> menuList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else if(sysUserEntity.getRoleType() == RoleEnum.ROLE_ADMIN.getCode()){
            List<SysMenuEntity> menuList = sysMenuMapper.queryMenuByTenantId(sysUserEntity.getTenantId());
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else {
            permsList = sysUserMapper.queryAllPerms(sysUserEntity.getUserId());
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
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return sysUserMapper.selectById(userId);
    }
}
