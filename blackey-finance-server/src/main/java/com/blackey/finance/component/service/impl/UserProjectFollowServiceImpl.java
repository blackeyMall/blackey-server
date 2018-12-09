package com.blackey.finance.component.service.impl;

import com.blackey.finance.dto.bo.UserProjectFollowBo;
import com.blackey.finance.dto.form.UserProjectFollowForm;
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

import java.util.List;
import java.util.Map;

/**
 * 用户关注项目表 UserProjectFollowServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserProjectFollowServiceImpl extends BaseServiceImpl<UserProjectFollowMapper, UserProjectFollow> implements UserProjectFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectFollowServiceImpl.class);


    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<UserProjectFollowBo> queryPage(UserProjectFollowForm form, Page<UserProjectFollowBo> page) {
        return baseMapper.queryPage(form,page);
    }
}
