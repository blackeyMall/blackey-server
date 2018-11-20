package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 审批详情表 BO
 * 
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Getter
@Setter
public class AuditDetailBo implements Serializable {

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

}
