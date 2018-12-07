package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 审批详情表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Getter
@Setter
public class AuditDetailForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 对象id
	 */
    private String objectId;
	/**
	 * 审批类型
	 */
    private String objectType;
	/**
	 * 原因
	 */
    private String reason;
	/**
	 * 审批人
	 */
    private String auditBy;
	/**
	 * 审批状态
	 */
    private String auditStatus;

}
