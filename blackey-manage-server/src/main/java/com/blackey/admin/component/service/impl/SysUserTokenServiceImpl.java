package com.blackey.admin.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysUserTokenMapper;
import com.blackey.admin.component.domain.SysUserToken;
import com.blackey.admin.component.service.SysUserTokenService;

import java.util.Map;

/**
 * 系统用户Token SysUserTokenServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysUserTokenServiceImpl extends BaseServiceImpl<SysUserTokenMapper, SysUserToken> implements SysUserTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserTokenServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserToken> page = (Page<SysUserToken>) this.page(
                new Query<SysUserToken>(params).getPage(),
                new QueryWrapper<SysUserToken>()
        );

        return new PageUtils(page);
    }

}
