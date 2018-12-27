package com.blackey.finance.component.service;

import com.blackey.finance.component.domain.ImageInfo;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 图片表 ImageInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:48:53
 */
public interface ImageInfoService extends BaseService<ImageInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

