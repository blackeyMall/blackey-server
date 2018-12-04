package com.blackey.flowers.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.flowers.component.domain.GoodsInfo;
import com.blackey.flowers.dto.bo.GoodsInfoBo;
import com.blackey.flowers.dto.form.GoodsInfoForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 商品表 GoodsInfoMapper
 * 
 * @author kaven
 * @date 2018-11-20 23:49:38
 */

public interface GoodsInfoMapper extends BaseDAO<GoodsInfo> {

    @Select("<script>" +
            "select g.id,g.goods_no,g.goods_name,g.goods_desc from t_goods_info g ORDER BY g.created_date DESC" +
            "</script>")
    List<GoodsInfoBo> getGoodsListPage(@Param("form") GoodsInfoForm goodsInfoForm, Page page);
}
