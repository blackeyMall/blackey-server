package com.blackey.finance.dto.form;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户信息表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Getter
@Setter
public class AccountInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
    private String openId;
	/**
	 * 微信id
	 */
    private String openid;
	/**
	 * 总金额
	 */
    private BigDecimal tatalAmount;
	/**
	 * 提现金额
	 */
    private BigDecimal withdrawAmount;

}
