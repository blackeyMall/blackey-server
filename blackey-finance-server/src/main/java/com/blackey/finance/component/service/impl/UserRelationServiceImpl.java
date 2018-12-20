package com.blackey.finance.component.service.impl;

import com.blackey.finance.dto.form.UserRelationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserRelationMapper;
import com.blackey.finance.component.domain.UserRelation;
import com.blackey.finance.component.service.UserRelationService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户好友关联表 UserRelationServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserRelationServiceImpl extends BaseServiceImpl<UserRelationMapper, UserRelation> implements UserRelationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRelationServiceImpl.class);

    @Resource
    private UserRelationMapper userRelationMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserRelation> page = (Page<UserRelation>) this.page(
                new Query<UserRelation>(params).getPage(),
                new QueryWrapper<UserRelation>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByOpenId(UserRelationForm form, Page page) {
        return new PageUtils(page.setRecords(userRelationMapper.findUserRelationByOpenId(form,page)));
    }
}
