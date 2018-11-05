package com.blackey.invest.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagAudirecord;

import java.util.Map;

/**
 * 管理员审核记录信息 DiagAudirecordService
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
public interface DiagAudirecordService extends BaseService<DiagAudirecord> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

