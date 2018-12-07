package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.RequirementInfo;

import java.util.Map;

/**
 * 需求信息表 RequirementInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface RequirementInfoService extends BaseService<RequirementInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

