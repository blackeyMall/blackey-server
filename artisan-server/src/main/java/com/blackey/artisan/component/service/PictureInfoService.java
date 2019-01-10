package com.blackey.artisan.component.service;

import com.blackey.artisan.global.constants.PicTypeStatus;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.PictureInfo;

import java.util.List;
import java.util.Map;

/**
 *  PictureInfoService
 *
 * @author kavenW
 * @date 2018-11-07 19:42:29
 */
public interface PictureInfoService extends BaseService<PictureInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);



    List<String> queryPicList(String objectId, PicTypeStatus picTypeStatus);

    /**
     * 保存图片
     * @param pics
     */
    void savePic(String objectId,String[] pics,PicTypeStatus status);
}

