package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 项目进展表
 *
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@Getter
@Setter
@TableName("diag_progress")
public class DiagProgress extends BaseModel<DiagProgress> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 项目进展编号
	 */
	private String progressNo;
	/**
	 * 项目编号
	 */
	private String projectNo;
	/**
	 * 项目进展描述
	 */
	private String progressDesc;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
