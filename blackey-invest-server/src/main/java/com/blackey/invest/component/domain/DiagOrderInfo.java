package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目订单信息
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
@TableName("diag_order_info")
public class DiagOrderInfo extends BaseModel<DiagOrderInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
