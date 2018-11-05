package com.blackey.invest.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagOrgInfo;

import java.util.Map;

/**
 * 企业诊断机构信息 DiagOrgInfoService
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
public interface DiagOrgInfoService extends BaseService<DiagOrgInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

