package com.blackey.finance.dto.form;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户流水明细表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class AccountDetailForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
    private String openId;
	/**
	 * 金额
	 */
    private BigDecimal amount;
	/**
	 * 账单来源
	 */
    private String source;
	/**
	 * 账单名称
	 */
    private String name;
	/**
	 * 流水号
	 */
    private Integer tradeNo;

}
