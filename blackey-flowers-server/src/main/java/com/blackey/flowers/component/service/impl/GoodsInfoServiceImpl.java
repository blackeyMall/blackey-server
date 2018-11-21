package com.blackey.flowers.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.flowers.component.mapper.GoodsInfoMapper;
import com.blackey.flowers.component.domain.GoodsInfo;
import com.blackey.flowers.component.service.GoodsInfoService;

import java.util.Map;

/**
 * 商品表 GoodsInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Service
public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsInfo> page = (Page<GoodsInfo>) this.page(
                new Query<GoodsInfo>(params).getPage(),
                new QueryWrapper<GoodsInfo>()
        );

        return new PageUtils(page);
    }

}
