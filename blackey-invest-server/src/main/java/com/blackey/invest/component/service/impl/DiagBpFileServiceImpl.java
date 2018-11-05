package com.blackey.invest.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagBpFileMapper;
import com.blackey.invest.component.domain.DiagBpFile;
import com.blackey.invest.component.service.DiagBpFileService;

import java.util.Map;

/**
 * 上传bp文件信息 DiagBpFileServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Service
public class DiagBpFileServiceImpl extends BaseServiceImpl<DiagBpFileMapper, DiagBpFile> implements DiagBpFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagBpFileServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagBpFile> page = (Page<DiagBpFile>) this.page(
                new Query<DiagBpFile>(params).getPage(),
                new QueryWrapper<DiagBpFile>()
        );

        return new PageUtils(page);
    }

}
