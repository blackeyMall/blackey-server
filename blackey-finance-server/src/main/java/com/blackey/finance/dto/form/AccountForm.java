package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户信息表 Form表单
 * 
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Getter
@Setter
public class AccountForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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
	 * 微信id
	 */
    private String openid;
	/**
	 * 总金额
	 */
    private String tatalAmount;
	/**
	 * 提现金额
	 */
    private String withdrawAmount;

}
