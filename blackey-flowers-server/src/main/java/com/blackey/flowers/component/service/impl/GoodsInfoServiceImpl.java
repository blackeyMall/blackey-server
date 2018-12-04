package com.blackey.flowers.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.flowers.component.domain.GoodsInfo;
import com.blackey.flowers.component.mapper.GoodsInfoMapper;
import com.blackey.flowers.component.service.GoodsInfoService;
import com.blackey.flowers.dto.bo.GoodsInfoBo;
import com.blackey.flowers.dto.form.GoodsInfoForm;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品表 GoodsInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Service
public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsInfo> page = (Page<GoodsInfo>) this.page(
                new Query<GoodsInfo>(params).getPage(),
                new QueryWrapper<GoodsInfo>()
        );

        return new PageUtils(page);
    }

    /**
     * 小程序 商品列表
     *
     * @param goodsInfoForm
     * @param page
     * @return
     */
    @Override
    public List<GoodsInfoBo> getGoodsListPage(GoodsInfoForm goodsInfoForm, Page<GoodsInfoBo> page) {

        return baseMapper.getGoodsListPage(goodsInfoForm,page);
    }

}
