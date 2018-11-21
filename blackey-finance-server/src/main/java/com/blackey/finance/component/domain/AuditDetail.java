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
 * @date 2018-11-20 23:27:02
 */
@Getter
@Setter
@TableName("audit_detail")
public class AuditDetail extends BaseModel<AuditDetail> implements Serializable {

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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
