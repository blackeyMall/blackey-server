package com.blackey.admin.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.dto.form.SysUserForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 系统用户 SysUserService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
    * 分页查询
    * @param form
     * @param page
    * @return
    */
    List<SysUser> queryPage(SysUserForm form, Page<SysUser> page);

    /**
     * 根据用户id查询管理菜单id
     * @param userId
     * @return
     */
    List<String> queryAllMenuIdByUserId(String userId);

    /**
     * 创建用户信息
     * @param sysUser
     */
    void createUser(SysUser sysUser);

    /**
     * 修改用户信息
     * @param sysUser
     */
    void updateUser(SysUser sysUser);

    /**
     * 删除用户信息
     * @param ids
     */
    void deleteUserBatch(String[] ids);

    /**
     * 更新密码
     * @param userId
     * @param password
     * @param newPassword
     * @return
     */
    boolean updatePassword(String userId, String password, String newPassword);

    /**
     * 用户登陆，根据account查询用户信息
     * @param account
     * @return
     */
    SysUser queryByUserAccount(String account);
}

