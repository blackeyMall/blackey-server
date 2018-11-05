package com.blackey.invest.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagProjecsetmeet;

import java.util.Map;

/**
 * 项目套餐信息描述 DiagProjecsetmeetService
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
public interface DiagProjecsetmeetService extends BaseService<DiagProjecsetmeet> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

