package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserRequireLikeMapper;
import com.blackey.finance.component.domain.UserRequireLike;
import com.blackey.finance.component.service.UserRequireLikeService;

import java.util.Map;

/**
 * 用户需求点赞表 UserRequireLikeServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserRequireLikeServiceImpl extends BaseServiceImpl<UserRequireLikeMapper, UserRequireLike> implements UserRequireLikeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireLikeServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserRequireLike> page = (Page<UserRequireLike>) this.page(
                new Query<UserRequireLike>(params).getPage(),
                new QueryWrapper<UserRequireLike>()
        );

        return new PageUtils(page);
    }

}
