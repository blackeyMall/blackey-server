package com.blackey.invest.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagEvaluateInfo;

import java.util.Map;

/**
 * 投资人评价信息 DiagEvaluateInfoService
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
public interface DiagEvaluateInfoService extends BaseService<DiagEvaluateInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

