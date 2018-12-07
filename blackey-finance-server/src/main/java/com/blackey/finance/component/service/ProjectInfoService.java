package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.ProjectInfo;

import java.util.Map;

/**
 * 项目信息表 ProjectInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface ProjectInfoService extends BaseService<ProjectInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

