package com.blackey.invest.component.service.impl;

import com.blackey.invest.dto.bo.DiagProjecinfoBo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.invest.component.mapper.DiagProjecinfoMapper;
import com.blackey.invest.component.domain.DiagProjecinfo;
import com.blackey.invest.component.service.DiagProjecinfoService;

import java.util.List;
import java.util.Map;

/**
 * 项目信息表 DiagProjecinfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@Service
public class DiagProjecinfoServiceImpl extends BaseServiceImpl<DiagProjecinfoMapper, DiagProjecinfo> implements DiagProjecinfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagProjecinfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiagProjecinfo> page = (Page<DiagProjecinfo>) this.page(
                new Query<DiagProjecinfo>(params).getPage(),
                new QueryWrapper<DiagProjecinfo>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<DiagProjecinfoBo> getProjectsPage(@Param("projectNo")String projectNo,Page page){


        return baseMapper.getProjectsPage(projectNo,page);
    }

}
