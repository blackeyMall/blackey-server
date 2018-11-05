package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagAudirecordMapper;
import com.blackey.invest.component.domain.DiagAudirecord;
import com.blackey.invest.component.service.DiagAudirecordService;

import java.util.Map;

/**
 * 管理员审核记录信息 DiagAudirecordServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Service
public class DiagAudirecordServiceImpl extends BaseServiceImpl<DiagAudirecordMapper, DiagAudirecord> implements DiagAudirecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagAudirecordServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagAudirecord> page = (Page<DiagAudirecord>) this.page(
                new Query<DiagAudirecord>(params).getPage(),
                new QueryWrapper<DiagAudirecord>()
        );

        return new PageUtils(page);
    }

}
