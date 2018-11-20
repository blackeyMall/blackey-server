package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.Requirement;

import java.util.Map;

/**
 * 需求信息表 RequirementService
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
public interface RequirementService extends BaseService<Requirement> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

