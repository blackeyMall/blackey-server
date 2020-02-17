package com.blackey.bbs.component.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.bbs.component.mapper.UserInfoMapper;
import com.blackey.bbs.component.domain.UserInfo;
import com.blackey.bbs.component.service.UserInfoService;

import java.util.Map;

/**
 * 会员用户信息表 UserInfoServiceImpl
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public IPage<UserInfo> queryPage(Map<String, Object> params) {
        IPage<UserInfo> page = this.page(
                new Query<UserInfo>(params).getPage(),
                new QueryWrapper<UserInfo>()
        );

        return page;
    }

}
