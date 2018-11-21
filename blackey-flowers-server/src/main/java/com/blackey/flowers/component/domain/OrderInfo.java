package com.blackey.flowers.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息表
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
@TableName("t_order_info")
public class OrderInfo extends BaseModel<OrderInfo> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 商品编号
	 */
	private String goodsNo;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品数量
	 */
	private Integer goodsCount;
	/**
	 * 地址编号
	 */
	private String addressNo;
	/**
	 * 地址详情
	 */
	private String addressDetail;
	/**
	 * 用户编号
	 */
	private String userNo;
	/**
	 * 订单状态
	 */
	private String tradeStatus;
	/**
	 * 支付状态
	 */
	private String payStatus;
	/**
	 * 备注
	 */
	private String remark;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                                

}
