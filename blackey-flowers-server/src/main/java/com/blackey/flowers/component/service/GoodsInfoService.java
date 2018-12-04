package com.blackey.flowers.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.flowers.dto.bo.GoodsInfoBo;
import com.blackey.flowers.dto.form.GoodsInfoForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.GoodsInfo;

import java.util.List;
import java.util.Map;

/**
 * 商品表 GoodsInfoService
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
public interface GoodsInfoService extends BaseService<GoodsInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);


    /**
     * 小程序 商品列表
     * @param goodsInfoForm
     * @param page
     * @return
     */
    List<GoodsInfoBo> getGoodsListPage(GoodsInfoForm goodsInfoForm, Page<GoodsInfoBo> page);
}

