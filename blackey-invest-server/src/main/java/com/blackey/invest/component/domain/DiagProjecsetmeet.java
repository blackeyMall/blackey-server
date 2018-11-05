package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目套餐信息描述
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
@TableName("diag_project_setmeet")
public class DiagProjecsetmeet extends BaseModel<DiagProjecsetmeet> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 项目套餐编号
	 */
	private String setmeetNo;
	/**
	 * 套餐金额
	 */
	private BigDecimal setmeetMoney;
	/**
	 * 最大评论人数
	 */
	private Integer maxEvaluate;
	/**
	 * 项目套餐描述
	 */
	private String setmeetDesc;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
