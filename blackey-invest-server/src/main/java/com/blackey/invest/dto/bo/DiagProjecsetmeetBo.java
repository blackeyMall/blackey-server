package com.blackey.invest.dto.bo;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目套餐信息描述 BO
 * 
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
public class DiagProjecsetmeetBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    private Long id;
	/**
	 * 项目套餐编号
	 */
    private String setmeetNo;
	/**
	 * 套餐金额
	 */
    private BigDecimal setmeetMoney;
	/**
	 * 最大评论人数
	 */
    private Integer maxEvaluate;
	/**
	 * 项目套餐描述
	 */
    private String setmeetDesc;
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
