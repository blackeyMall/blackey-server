package com.blackey.flowers.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.flowers.global.constants.OrderStatus;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

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
	private OrderStatus tradeStatus;
	/**
	 * 支付状态
	 */
	private String payStatus;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 订单总额
	 */
	private BigDecimal amount;
	/**
	 * 推荐人id
	 */
	private String refereeId;
	/**
	 * 类型 0 一周一次  1 三周三次
	 */
	private String goodsType;
	/**
	 * 微信支付订单号
	 */
	private String transactionId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                                

}
