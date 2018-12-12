package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.ObjectTypeEnum;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 审批详情表
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Getter
@Setter
@TableName("t_audit_detail")
public class AuditDetail extends BaseModel<AuditDetail> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 对象id
	 */
	private String objectId;
	/**
	 * 审批类型
	 */
	private ObjectTypeEnum objectType = ObjectTypeEnum.PROJECT;
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
	private AuditStatusEnum auditStatus = AuditStatusEnum.WAITING;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                    

}
