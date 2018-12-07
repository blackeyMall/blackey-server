package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 账户流水明细表
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
@TableName("t_account_detail")
public class AccountDetail extends BaseModel<AccountDetail> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId
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

    @Override
    protected Serializable pkVal() {
        return this.getOpenId();
    }
                    

}
