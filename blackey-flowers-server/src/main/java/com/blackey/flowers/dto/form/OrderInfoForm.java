package com.blackey.flowers.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息表 Form表单
 * 
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
public class OrderInfoForm implements Serializable {

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
    private String tradeStatus;
	/**
	 * 支付状态
	 */
    private String payStatus;
	/**
	 * 备注
	 */
    private String remark;

}
