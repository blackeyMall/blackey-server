package com.blackey.artisan.component.mapper;

import com.blackey.artisan.component.domain.PictureInfo;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *  PictureInfoMapper
 * 
 * @author kavenW
 * @date 2018-11-07 19:42:29
 */

public interface PictureInfoMapper extends BaseDAO<PictureInfo> {


    List<String> queryPicList(@Param("objectId") String objectId);
}
