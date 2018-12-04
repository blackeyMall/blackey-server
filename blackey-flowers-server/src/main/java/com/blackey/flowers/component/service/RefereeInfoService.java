package com.blackey.flowers.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.RefereeInfo;

import java.util.Map;

/**
 *  RefereeInfoService
 *
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
public interface RefereeInfoService extends BaseService<RefereeInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

