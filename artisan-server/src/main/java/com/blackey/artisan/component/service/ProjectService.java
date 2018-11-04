package com.blackey.artisan.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.Project;

import java.util.Map;

/**
 *  ProjectService
 *
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
public interface ProjectService extends BaseService<Project> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

