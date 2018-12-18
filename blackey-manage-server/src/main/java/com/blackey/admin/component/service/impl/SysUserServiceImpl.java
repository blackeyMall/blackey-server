package com.blackey.admin.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysUserMapper;
import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.service.SysUserService;

import java.util.List;
import java.util.Map;

/**
 * 系统用户 SysUserServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUser> page = (Page<SysUser>) this.page(
                new Query<SysUser>(params).getPage(),
                new QueryWrapper<SysUser>()
        );

        return new PageUtils(page);
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

}
