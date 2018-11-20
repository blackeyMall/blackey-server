package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.ImageMapper;
import com.blackey.finance.component.domain.Image;
import com.blackey.finance.component.service.ImageService;

import java.util.Map;

/**
 * 图片表 ImageServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Service
public class ImageServiceImpl extends BaseServiceImpl<ImageMapper, Image> implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Image> page = (Page<Image>) this.page(
                new Query<Image>(params).getPage(),
                new QueryWrapper<Image>()
        );

        return new PageUtils(page);
    }

}
