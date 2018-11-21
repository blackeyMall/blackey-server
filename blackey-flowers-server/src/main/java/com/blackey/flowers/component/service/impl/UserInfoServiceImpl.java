package com.blackey.flowers.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.flowers.component.mapper.UserInfoMapper;
import com.blackey.flowers.component.domain.UserInfo;
import com.blackey.flowers.component.service.UserInfoService;

import java.util.Map;

/**
 * 用户信息表 UserInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserInfo> page = (Page<UserInfo>) this.page(
                new Query<UserInfo>(params).getPage(),
                new QueryWrapper<UserInfo>()
        );

        return new PageUtils(page);
    }

}
