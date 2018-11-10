package com.blackey.artisan.component.service;

import com.blackey.artisan.dto.bo.MaterialBo;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.Material;

import java.util.Map;

/**
 *  MaterialService
 *
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
public interface MaterialService extends BaseService<Material> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

//    /**
//     * 根据projectId 查询材料清单
//     * @param projectId
//     * @return
//     */
//    MaterialBo getByProId(String projectId);
}
