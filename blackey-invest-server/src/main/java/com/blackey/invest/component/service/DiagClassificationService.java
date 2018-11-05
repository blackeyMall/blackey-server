package com.blackey.invest.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagClassification;

import java.util.Map;

/**
 * 项目分类 DiagClassificationService
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
public interface DiagClassificationService extends BaseService<DiagClassification> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

