package com.blackey.finance.component.service;

import com.blackey.finance.component.domain.ImageInfo;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
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

    /**
     *
     * @param objectId
     * @param imageType
     * @return
     */
    List<String> queryImagesUrl(String objectId,String imageType);

    /**
     * 删除图片信息
     * @param objectId
     * @param imageType
     */
    void deleteImagesByObjectId(String objectId,String imageType);
}

