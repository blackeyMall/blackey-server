package com.blackey.admin.component.service;

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
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据用户id查询管理菜单id
     * @param userId
     * @return
     */
    List<String> queryAllMenuIdByUserId(String userId);
}

