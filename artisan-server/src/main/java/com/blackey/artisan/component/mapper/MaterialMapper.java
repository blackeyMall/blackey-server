package com.blackey.artisan.component.mapper;

import com.blackey.artisan.component.domain.Material;
import com.blackey.artisan.dto.bo.MaterialBo;
import com.blackey.mybatis.dao.BaseDAO;


/**
 *  MaterialMapper
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */

public interface MaterialMapper extends BaseDAO<Material> {

    MaterialBo getByOrderId(String orderId);
}
