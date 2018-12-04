package com.blackey.flowers.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 商品表
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
@TableName("t_goods_info")
public class GoodsInfo extends BaseModel<GoodsInfo> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 商品编号
	 */
	private String goodsNo;
	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品描述
	 */
	private String goodsDesc;



    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                

}
