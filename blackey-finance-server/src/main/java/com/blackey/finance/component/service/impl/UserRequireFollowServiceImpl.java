package com.blackey.finance.component.service.impl;

import com.blackey.finance.dto.bo.UserRequireFollowBo;
import com.blackey.finance.dto.form.UserRequireFollowForm;
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

import java.util.List;
import java.util.Map;

/**
 * 用户需求关注表 UserRequireFollowServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserRequireFollowServiceImpl extends BaseServiceImpl<UserRequireFollowMapper, UserRequireFollow> implements UserRequireFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireFollowServiceImpl.class);


    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<UserRequireFollowBo> queryPage(UserRequireFollowForm form, Page<UserRequireFollowBo> page) {
        return baseMapper.queryPage(form,page);
    }
}
