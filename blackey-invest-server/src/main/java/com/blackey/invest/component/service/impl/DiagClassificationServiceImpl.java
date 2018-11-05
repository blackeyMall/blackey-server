package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagClassificationMapper;
import com.blackey.invest.component.domain.DiagClassification;
import com.blackey.invest.component.service.DiagClassificationService;

import java.util.Map;

/**
 * 项目分类 DiagClassificationServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Service
public class DiagClassificationServiceImpl extends BaseServiceImpl<DiagClassificationMapper, DiagClassification> implements DiagClassificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagClassificationServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagClassification> page = (Page<DiagClassification>) this.page(
                new Query<DiagClassification>(params).getPage(),
                new QueryWrapper<DiagClassification>()
        );

        return new PageUtils(page);
    }

}
