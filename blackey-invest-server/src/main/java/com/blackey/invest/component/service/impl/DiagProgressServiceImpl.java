package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagProgressMapper;
import com.blackey.invest.component.domain.DiagProgress;
import com.blackey.invest.component.service.DiagProgressService;

import java.util.Map;

/**
 * 项目进展表 DiagProgressServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@Service
public class DiagProgressServiceImpl extends BaseServiceImpl<DiagProgressMapper, DiagProgress> implements DiagProgressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagProgressServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagProgress> page = (Page<DiagProgress>) this.page(
                new Query<DiagProgress>(params).getPage(),
                new QueryWrapper<DiagProgress>()
        );

        return new PageUtils(page);
    }

}
