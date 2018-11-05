package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 管理员审核记录信息
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
@TableName("diag_audit_record")
public class DiagAudirecord extends BaseModel<DiagAudirecord> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 审核记录编号
	 */
	private String recordNo;
	/**
	 * 审核状态2审核通过、3审核拒绝
	 */
	private Integer recordStatus;
	/**
	 * 项目编号
	 */
	private String projectNo;
	/**
	 * 审核描述
	 */
	private String recordDesc;


    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
