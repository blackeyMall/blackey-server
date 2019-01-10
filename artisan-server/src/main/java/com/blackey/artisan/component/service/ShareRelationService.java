package com.blackey.artisan.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.ShareRelation;

import java.util.Map;

/**
 *  ShareRelationService
 *
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
public interface ShareRelationService extends BaseService<ShareRelation> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);


    /**
     * 查询该用户是否有上级
     */
    String exsitParent(String openid);

}

