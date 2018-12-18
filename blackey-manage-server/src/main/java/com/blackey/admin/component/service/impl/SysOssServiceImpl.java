package com.blackey.admin.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysOssMapper;
import com.blackey.admin.component.domain.SysOss;
import com.blackey.admin.component.service.SysOssService;

import java.util.Map;

/**
 * 文件上传 SysOssServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysOssServiceImpl extends BaseServiceImpl<SysOssMapper, SysOss> implements SysOssService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysOssServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysOss> page = (Page<SysOss>) this.page(
                new Query<SysOss>(params).getPage(),
                new QueryWrapper<SysOss>()
        );

        return new PageUtils(page);
    }

}
