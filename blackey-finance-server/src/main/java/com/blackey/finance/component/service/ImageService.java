package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.Image;

import java.util.Map;

/**
 * 图片表 ImageService
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
public interface ImageService extends BaseService<Image> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

