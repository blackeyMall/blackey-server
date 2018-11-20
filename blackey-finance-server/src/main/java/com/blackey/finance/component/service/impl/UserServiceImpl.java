package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserMapper;
import com.blackey.finance.component.domain.User;
import com.blackey.finance.component.service.UserService;

import java.util.Map;

/**
 * 用户信息表 UserServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<User> page = (Page<User>) this.page(
                new Query<User>(params).getPage(),
                new QueryWrapper<User>()
        );

        return new PageUtils(page);
    }

}
