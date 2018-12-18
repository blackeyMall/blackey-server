package com.blackey.admin.component.service.impl;

import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.service.SysRoleMenuService;
import com.blackey.admin.component.service.SysUserRoleService;
import com.blackey.admin.component.service.SysUserService;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.common.exception.PermissionException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysRoleMapper;
import com.blackey.admin.component.domain.SysRole;
import com.blackey.admin.component.service.SysRoleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色 SysRoleServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysRoleMenuService sysRoleMenuService;
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String)params.get("roleName");
        String createUserId = (String)params.get("createUserId");

        Page<SysRole> page = (Page<SysRole>) this.page(
                new Query<SysRole>(params).getPage(),
                new QueryWrapper<SysRole>()
                        .like(StringUtils.isNotBlank(roleName),"role_name", roleName)
                        .eq(createUserId != null,"created_by", createUserId)
        );

        return new PageUtils(page);
    }

    /**
     * 创建角色
     *
     * @param role
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(SysRole role) {

        role.setCreatedDate(new Date());
        this.save(role);

        //检查权限是否越权
        checkPrems(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getId(), role.getMenuIdList());
    }

    /**
     * 更新角色
     *
     * @param role
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(SysRole role) {
        this.updateById(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getId(), role.getMenuIdList());
    }

    /**
     * 批量删除角色
     *
     * @param roleIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] roleIds) {

        //删除角色
        this.removeByIds(Arrays.asList(roleIds));
        //删除角色与菜单关联
        sysRoleMenuService.deleteBatch(roleIds);
        //删除角色与用户关联
        sysUserRoleService.deleteBatch(roleIds);
    }

    /**
     * 查询用户创建的角色ID列表
     *
     * @param createdBy
     * @return
     */
    @Override
    public List<String> queryRoleIdList(String createdBy) {

        return baseMapper.queryRoleIdList(createdBy);
    }


    /**
     * 检查权限是否越权
     */
    private void checkPrems(SysRole role){

        SysUser sysUser = sysUserService.getById(role.getCreatedBy());

        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if(sysUser.getRoleType() == RoleEnum.ROLE_SUPER.getCode()
                || sysUser.getRoleType() == RoleEnum.ROLE_ADMIN.getCode()){
            return ;
        }

        //查询用户所拥有的菜单列表
        List<String> menuIdList = sysUserService.queryAllMenuIdByUserId(sysUser.getId());

        //判断是否越权
        if(!menuIdList.containsAll(role.getMenuIdList())){
            throw new PermissionException();
        }
    }
}
