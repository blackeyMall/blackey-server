package com.blackey.flowers.dto.bo;

import com.blackey.flowers.global.constants.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息表 BO
 * 
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
public class OrderInfoBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private String id;
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
	 * 删除标志
	 */
    private Integer isDeleted;
	/**
	 * 创建人
	 */
    private String createdBy;
	/**
	 * 创建时间
	 */
    private Date createdDate;
	/**
	 * 修改人
	 */
    private String updatedBy;
	/**
	 * 修改时间
	 */
    private Date updatedDate;
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
	 * 商品名称
	 */
	private String goodsDesc;

	/**
	 * 类型 0 一周一次  1 三周三次
	 */
	private String goodsType;

	/**
	 * 微信昵称
	 */
	private String nickName;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 推荐人姓名
	 */
	private String refereeName;


}
