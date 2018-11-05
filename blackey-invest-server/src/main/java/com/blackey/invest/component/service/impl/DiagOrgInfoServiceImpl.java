package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagOrgInfoMapper;
import com.blackey.invest.component.domain.DiagOrgInfo;
import com.blackey.invest.component.service.DiagOrgInfoService;

import java.util.Map;

/**
 * 企业诊断机构信息 DiagOrgInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Service
public class DiagOrgInfoServiceImpl extends BaseServiceImpl<DiagOrgInfoMapper, DiagOrgInfo> implements DiagOrgInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagOrgInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagOrgInfo> page = (Page<DiagOrgInfo>) this.page(
                new Query<DiagOrgInfo>(params).getPage(),
                new QueryWrapper<DiagOrgInfo>()
        );

        return new PageUtils(page);
    }

}
