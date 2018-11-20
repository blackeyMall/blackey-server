package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户流水明细表
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Getter
@Setter
@TableName("account_detail")
public class AccountDetail extends BaseModel<AccountDetail> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private Integer isDeleted;
	/**
	 * 
	 */
	private String createdBy;
	/**
	 * 
	 */
	private Date createdDate;
	/**
	 * 
	 */
	private String updatedBy;
	/**
	 * 
	 */
	private Date updatedDate;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 金额
	 */
	private String amount;
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
        return this.getId();
    }
                                            

}
