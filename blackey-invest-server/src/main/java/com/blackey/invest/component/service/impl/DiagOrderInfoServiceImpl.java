package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagOrderInfoMapper;
import com.blackey.invest.component.domain.DiagOrderInfo;
import com.blackey.invest.component.service.DiagOrderInfoService;

import java.util.Map;

/**
 * 项目订单信息 DiagOrderInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Service
public class DiagOrderInfoServiceImpl extends BaseServiceImpl<DiagOrderInfoMapper, DiagOrderInfo> implements DiagOrderInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagOrderInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagOrderInfo> page = (Page<DiagOrderInfo>) this.page(
                new Query<DiagOrderInfo>(params).getPage(),
                new QueryWrapper<DiagOrderInfo>()
        );

        return new PageUtils(page);
    }

}
