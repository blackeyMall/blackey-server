package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 投资人评价信息
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
@TableName("diag_evaluate_info")
public class DiagEvaluateInfo extends BaseModel<DiagEvaluateInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 投资人评价编号
	 */
	private String evaluateNo;
	/**
	 * 项目编号
	 */
	private String projectNo;
	/**
	 * 评价等级，A,B,C
	 */
	private Integer evaluateGrade;
	/**
	 * 评价描述
	 */
	private String evaluateDesc;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
