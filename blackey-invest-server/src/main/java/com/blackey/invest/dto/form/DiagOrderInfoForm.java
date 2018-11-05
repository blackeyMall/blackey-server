package com.blackey.invest.dto.form;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目订单信息 Form表单
 * 
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
public class DiagOrderInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private Integer id;
	/**
	 * 分类编号
	 */
    private String orderNo;
	/**
	 * 分类名称
	 */
    private BigDecimal orderMoney;
	/**
	 * 项目编号
	 */
    private String projectNo;
	/**
	 * 订单状态
	 */
    private Integer status;
	/**
	 * 逻辑删除
	 */
    private Integer isDeleted;
	/**
	 * 创建人
	 */
    private String createBy;
	/**
	 * 创建时间
	 */
    private Date createDate;
	/**
	 * 更新人
	 */
    private String updateBy;
	/**
	 * 更新时间
	 */
    private Date updateDate;

}
