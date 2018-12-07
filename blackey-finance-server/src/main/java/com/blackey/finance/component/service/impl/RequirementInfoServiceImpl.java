package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.RequirementInfoMapper;
import com.blackey.finance.component.domain.RequirementInfo;
import com.blackey.finance.component.service.RequirementInfoService;

import java.util.Map;

/**
 * 需求信息表 RequirementInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class RequirementInfoServiceImpl extends BaseServiceImpl<RequirementInfoMapper, RequirementInfo> implements RequirementInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequirementInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RequirementInfo> page = (Page<RequirementInfo>) this.page(
                new Query<RequirementInfo>(params).getPage(),
                new QueryWrapper<RequirementInfo>()
        );

        return new PageUtils(page);
    }

}
