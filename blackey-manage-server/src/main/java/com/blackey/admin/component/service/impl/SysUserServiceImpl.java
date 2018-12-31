package com.blackey.admin.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.domain.SysUserRole;
import com.blackey.admin.component.mapper.SysUserMapper;
import com.blackey.admin.component.service.SysRoleService;
import com.blackey.admin.component.service.SysUserRoleService;
import com.blackey.admin.component.service.SysUserService;
import com.blackey.admin.dto.form.SysUserForm;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.common.exception.PermissionException;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统用户 SysUserServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    SysRoleService sysRoleService;
    @Resource
    SysUserRoleService sysUserRoleService;


    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<SysUser> queryPage(SysUserForm form, Page<SysUser> page) {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        //超级管理员
        if(form.getRoleType() == RoleEnum.ROLE_ADMIN.getCode()){
            queryWrapper.eq("tenant_id", form.getTenantId());
        }

        if(StringUtils.isNotBlank(form.getMobile())){
            queryWrapper.eq("mobile", form.getMobile());
        }
        if(StringUtils.isNotBlank(form.getAccount())){
            queryWrapper.eq("account", form.getAccount());
        }
        if(StringUtils.isNotBlank(form.getUserName())){
            queryWrapper.like("user_name", form.getUserName());
        }
        queryWrapper.orderByDesc("created_date");
        IPage<SysUser> userIPage = this.page(page, queryWrapper);

        return userIPage.getRecords();
    }

    /**
     * 根据用户id查询管理菜单id
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> queryAllMenuIdByUserId(String userId) {
        return baseMapper.queryAllMenuIdByUserId(userId);
    }

    /**
     * 创建用户信息
     *
     * @param sysUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(SysUser sysUser) {
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUser.setPassword(new Sha256Hash(sysUser.getPassword(), salt).toHex());
        sysUser.setSalt(salt);
        baseMapper.insert(sysUser);
        checkRole(sysUser);
        //保存用户角色关联信息
        sysUserRoleService.saveOrUpdateUserRole(sysUser.getId(),sysUser.getRoleIdList());

    }

    /**
     * 修改用户信息
     *
     * @param sysUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(SysUser sysUser) {
        if(StringUtils.isBlank(sysUser.getPassword())){
            sysUser.setPassword(null);
        }else {
            sysUser.setPassword(new Sha256Hash(sysUser.getPassword(), sysUser.getSalt()).toHex());
        }
        this.updateById(sysUser);
        //检查角色是否越权
        checkRole(sysUser);
        //保存用户与角色关系
        sysUserRoleService.saveOrUpdateUserRole(sysUser.getId(), sysUser.getRoleIdList());
    }

    /**
     * 删除用户信息
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserBatch(String[] ids) {
        for (String id : ids){
            baseMapper.deleteById(id);
            //删除用户关联的角色
            sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("user_id",id));
        }
    }

    /**
     * 更新密码
     *
     * @param userId
     * @param password
     * @param newPassword
     * @return
     */
    @Override
    public boolean updatePassword(String userId, String password, String newPassword) {

        SysUser sysUser = new SysUser();
        sysUser.setPassword(newPassword);

        return this.update(sysUser,new UpdateWrapper<SysUser>()
                .eq("id",userId));

    }

    /**
     * 用户登陆，根据account查询用户信息
     *
     * @param account
     * @return
     */
    @Override
    public SysUser queryByUserAccount(String account) {

        return baseMapper.selectOne(new QueryWrapper<SysUser>()
                .eq("account",account).orderByDesc("created_date"));
    }


    /**
     * 检查角色是否越权
     */
    private void checkRole(SysUser user){
        if(user.getRoleIdList() == null || user.getRoleIdList().size() == 0){
            return;
        }
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        SysUser createUser = this.getById(user.getCreatedBy());
        if(createUser.getRoleType() == RoleEnum.ROLE_SUPER.getCode()
                || createUser.getRoleType() == RoleEnum.ROLE_ADMIN.getCode()){
            return ;
        }

        //查询用户创建的角色列表
        List<String> roleIdList = sysRoleService.queryRoleIdList(user.getCreatedBy());

        //判断是否越权
        if(!roleIdList.containsAll(user.getRoleIdList())){
            throw new PermissionException();
        }
    }
}
