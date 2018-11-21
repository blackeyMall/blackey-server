package com.blackey.flowers.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.GoodsInfo;

import java.util.Map;

/**
 * 商品表 GoodsInfoService
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
public interface GoodsInfoService extends BaseService<GoodsInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

