package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagProjecsetmeetMapper;
import com.blackey.invest.component.domain.DiagProjecsetmeet;
import com.blackey.invest.component.service.DiagProjecsetmeetService;

import java.util.Map;

/**
 * 项目套餐信息描述 DiagProjecsetmeetServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Service
public class DiagProjecsetmeetServiceImpl extends BaseServiceImpl<DiagProjecsetmeetMapper, DiagProjecsetmeet> implements DiagProjecsetmeetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagProjecsetmeetServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagProjecsetmeet> page = (Page<DiagProjecsetmeet>) this.page(
                new Query<DiagProjecsetmeet>(params).getPage(),
                new QueryWrapper<DiagProjecsetmeet>()
        );

        return new PageUtils(page);
    }

}
