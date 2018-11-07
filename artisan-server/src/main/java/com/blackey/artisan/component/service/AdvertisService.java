package com.blackey.artisan.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.Advertis;

import java.util.Map;

/**
 *  AdvertisService
 *
 * @author kavenW
 * @date 2018-11-07 09:50:15
 */
public interface AdvertisService extends BaseService<Advertis> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

