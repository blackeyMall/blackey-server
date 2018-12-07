package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserProjectLikeMapper;
import com.blackey.finance.component.domain.UserProjectLike;
import com.blackey.finance.component.service.UserProjectLikeService;

import java.util.Map;

/**
 * 用户点赞项目表 UserProjectLikeServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserProjectLikeServiceImpl extends BaseServiceImpl<UserProjectLikeMapper, UserProjectLike> implements UserProjectLikeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectLikeServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserProjectLike> page = (Page<UserProjectLike>) this.page(
                new Query<UserProjectLike>(params).getPage(),
                new QueryWrapper<UserProjectLike>()
        );

        return new PageUtils(page);
    }

}
