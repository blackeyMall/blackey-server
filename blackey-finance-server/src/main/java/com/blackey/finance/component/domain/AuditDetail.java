package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

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
	@TableId
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

    @Override
    protected Serializable pkVal() {
        return this.getObjectId();
    }
                    

}
