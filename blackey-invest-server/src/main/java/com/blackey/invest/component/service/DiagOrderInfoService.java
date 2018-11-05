package com.blackey.invest.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagOrderInfo;

import java.util.Map;

/**
 * 项目订单信息 DiagOrderInfoService
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
public interface DiagOrderInfoService extends BaseService<DiagOrderInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

