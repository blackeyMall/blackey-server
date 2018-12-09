package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 账户信息表
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Getter
@Setter
@TableName("t_account_info")
public class AccountInfo extends BaseModel<AccountInfo> implements Serializable {

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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                

}
