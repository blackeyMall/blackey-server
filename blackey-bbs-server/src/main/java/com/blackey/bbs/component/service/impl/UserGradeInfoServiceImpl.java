package com.blackey.bbs.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.bbs.component.mapper.UserGradeInfoMapper;
import com.blackey.bbs.component.domain.UserGradeInfo;
import com.blackey.bbs.component.service.UserGradeInfoService;

import java.util.Map;

/**
 * 会员等级信息表 UserGradeInfoServiceImpl
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@Service
public class UserGradeInfoServiceImpl extends BaseServiceImpl<UserGradeInfoMapper, UserGradeInfo> implements UserGradeInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGradeInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserGradeInfo> page = (Page<UserGradeInfo>) this.page(
                new Query<UserGradeInfo>(params).getPage(),
                new QueryWrapper<UserGradeInfo>()
        );

        return new PageUtils(page);
    }

}
