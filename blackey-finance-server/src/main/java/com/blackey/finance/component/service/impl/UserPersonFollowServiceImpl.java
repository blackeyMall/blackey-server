package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserPersonFollowMapper;
import com.blackey.finance.component.domain.UserPersonFollow;
import com.blackey.finance.component.service.UserPersonFollowService;

import java.util.Map;

/**
 * 用户关注用户表 UserPersonFollowServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserPersonFollowServiceImpl extends BaseServiceImpl<UserPersonFollowMapper, UserPersonFollow> implements UserPersonFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPersonFollowServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserPersonFollow> page = (Page<UserPersonFollow>) this.page(
                new Query<UserPersonFollow>(params).getPage(),
                new QueryWrapper<UserPersonFollow>()
        );

        return new PageUtils(page);
    }

}
