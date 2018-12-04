package com.blackey.flowers.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.flowers.component.mapper.RefereeInfoMapper;
import com.blackey.flowers.component.domain.RefereeInfo;
import com.blackey.flowers.component.service.RefereeInfoService;

import java.util.Map;

/**
 *  RefereeInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
@Service
public class RefereeInfoServiceImpl extends BaseServiceImpl<RefereeInfoMapper, RefereeInfo> implements RefereeInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefereeInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RefereeInfo> page = (Page<RefereeInfo>) this.page(
                new Query<RefereeInfo>(params).getPage(),
                new QueryWrapper<RefereeInfo>()
        );

        return new PageUtils(page);
    }

}
