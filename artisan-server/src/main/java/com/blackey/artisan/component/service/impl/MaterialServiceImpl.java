package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.MaterialMapper;
import com.blackey.artisan.component.domain.Material;
import com.blackey.artisan.component.service.MaterialService;

import java.util.Map;

/**
 *  MaterialServiceImpl
 *
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
@Service
public class MaterialServiceImpl extends BaseServiceImpl<MaterialMapper, Material> implements MaterialService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Material> page = (Page<Material>) this.page(
                new Query<Material>(params).getPage(),
                new QueryWrapper<Material>()
        );

        return new PageUtils(page);
    }

}
