package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagEvaluateInfoMapper;
import com.blackey.invest.component.domain.DiagEvaluateInfo;
import com.blackey.invest.component.service.DiagEvaluateInfoService;

import java.util.Map;

/**
 * 投资人评价信息 DiagEvaluateInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Service
public class DiagEvaluateInfoServiceImpl extends BaseServiceImpl<DiagEvaluateInfoMapper, DiagEvaluateInfo> implements DiagEvaluateInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagEvaluateInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagEvaluateInfo> page = (Page<DiagEvaluateInfo>) this.page(
                new Query<DiagEvaluateInfo>(params).getPage(),
                new QueryWrapper<DiagEvaluateInfo>()
        );

        return new PageUtils(page);
    }

}
