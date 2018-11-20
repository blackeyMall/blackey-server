package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserProjectFollowMapper;
import com.blackey.finance.component.domain.UserProjectFollow;
import com.blackey.finance.component.service.UserProjectFollowService;

import java.util.Map;

/**
 * 用户关注项目表 UserProjectFollowServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Service
public class UserProjectFollowServiceImpl extends BaseServiceImpl<UserProjectFollowMapper, UserProjectFollow> implements UserProjectFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectFollowServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserProjectFollow> page = (Page<UserProjectFollow>) this.page(
                new Query<UserProjectFollow>(params).getPage(),
                new QueryWrapper<UserProjectFollow>()
        );

        return new PageUtils(page);
    }

}
