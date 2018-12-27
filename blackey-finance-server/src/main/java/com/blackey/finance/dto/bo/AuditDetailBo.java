package com.blackey.finance.dto.bo;

import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.ObjectTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 审批详情表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Getter
@Setter
public class AuditDetailBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
	/**
	 * 对象id
	 */
    private String objectId;
	/**
	 * 审批类型
	 */
    private ObjectTypeEnum objectType;
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
    private AuditStatusEnum auditStatus;
	/**
	 * 项目名称
	 */
	private String name;
	/**
	 * 姓名
	 */
	private String userName;
	/**
	 * 创建时间
	 */
	private Date createdDate;


}
