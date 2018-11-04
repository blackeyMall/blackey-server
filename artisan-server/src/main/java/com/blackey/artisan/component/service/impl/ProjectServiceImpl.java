package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.ProjectMapper;
import com.blackey.artisan.component.domain.Project;
import com.blackey.artisan.component.service.ProjectService;

import java.util.Map;

/**
 *  ProjectServiceImpl
 *
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectMapper, Project> implements ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Project> page = (Page<Project>) this.page(
                new Query<Project>(params).getPage(),
                new QueryWrapper<Project>()
        );

        return new PageUtils(page);
    }

}
