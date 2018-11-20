package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.Project;

import java.util.Map;

/**
 * 项目信息表 ProjectService
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
public interface ProjectService extends BaseService<Project> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

