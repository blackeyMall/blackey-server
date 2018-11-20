package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.RequirementMapper;
import com.blackey.finance.component.domain.Requirement;
import com.blackey.finance.component.service.RequirementService;

import java.util.Map;

/**
 * 需求信息表 RequirementServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Service
public class RequirementServiceImpl extends BaseServiceImpl<RequirementMapper, Requirement> implements RequirementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequirementServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Requirement> page = (Page<Requirement>) this.page(
                new Query<Requirement>(params).getPage(),
                new QueryWrapper<Requirement>()
        );

        return new PageUtils(page);
    }

}
