package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.ImageInfoMapper;
import com.blackey.finance.component.domain.ImageInfo;
import com.blackey.finance.component.service.ImageInfoService;

import java.util.Map;

/**
 * 图片表 ImageInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:48:53
 */
@Service
public class ImageInfoServiceImpl extends BaseServiceImpl<ImageInfoMapper, ImageInfo> implements ImageInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ImageInfo> page = (Page<ImageInfo>) this.page(
                new Query<ImageInfo>(params).getPage(),
                new QueryWrapper<ImageInfo>()
        );

        return new PageUtils(page);
    }

}
