package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserRequireFollowMapper;
import com.blackey.finance.component.domain.UserRequireFollow;
import com.blackey.finance.component.service.UserRequireFollowService;

import java.util.Map;

/**
 * 用户需求关注表 UserRequireFollowServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Service
public class UserRequireFollowServiceImpl extends BaseServiceImpl<UserRequireFollowMapper, UserRequireFollow> implements UserRequireFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireFollowServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserRequireFollow> page = (Page<UserRequireFollow>) this.page(
                new Query<UserRequireFollow>(params).getPage(),
                new QueryWrapper<UserRequireFollow>()
        );

        return new PageUtils(page);
    }

}
