package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.PictureInfoMapper;
import com.blackey.artisan.component.domain.PictureInfo;
import com.blackey.artisan.component.service.PictureInfoService;

import java.util.Map;

/**
 *  PictureInfoServiceImpl
 *
 * @author kavenW
 * @date 2018-11-07 19:42:29
 */
@Service
public class PictureInfoServiceImpl extends BaseServiceImpl<PictureInfoMapper, PictureInfo> implements PictureInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PictureInfo> page = (Page<PictureInfo>) this.page(
                new Query<PictureInfo>(params).getPage(),
                new QueryWrapper<PictureInfo>()
        );

        return new PageUtils(page);
    }

}
