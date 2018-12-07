package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.AuditDetailMapper;
import com.blackey.finance.component.domain.AuditDetail;
import com.blackey.finance.component.service.AuditDetailService;

import java.util.Map;

/**
 * 审批详情表 AuditDetailServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Service
public class AuditDetailServiceImpl extends BaseServiceImpl<AuditDetailMapper, AuditDetail> implements AuditDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditDetailServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AuditDetail> page = (Page<AuditDetail>) this.page(
                new Query<AuditDetail>(params).getPage(),
                new QueryWrapper<AuditDetail>()
        );

        return new PageUtils(page);
    }

}
