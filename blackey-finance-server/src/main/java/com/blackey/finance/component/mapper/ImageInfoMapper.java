package com.blackey.finance.component.mapper;

import com.blackey.finance.component.domain.ImageInfo;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 图片表 ImageInfoMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:48:53
 */

public interface ImageInfoMapper extends BaseDAO<ImageInfo> {
    @Select(" SELECT\n" +
            "        image_url \n" +
            "    FROM\n" +
            "        t_image_info \n" +
            "    WHERE\n" +
            "        is_deleted=0 \n" +
            "        AND object_id = #{objectId} \n" +
            "        AND image_type = #{imageType}")
    List<String> queryImagesUrl(@Param("objectId") String objectId, @Param("imageType") String imageType);
}
