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
	@TableId
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
        return this.getOpenId();
    }
                

}
