package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.AdvertisMapper;
import com.blackey.artisan.component.domain.Advertis;
import com.blackey.artisan.component.service.AdvertisService;

import java.util.Map;

/**
 *  AdvertisServiceImpl
 *
 * @author kavenW
 * @date 2018-11-07 09:50:15
 */
@Service
public class AdvertisServiceImpl extends BaseServiceImpl<AdvertisMapper, Advertis> implements AdvertisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdvertisServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Advertis> page = (Page<Advertis>) this.page(
                new Query<Advertis>(params).getPage(),
                new QueryWrapper<Advertis>()
        );

        return new PageUtils(page);
    }

}
