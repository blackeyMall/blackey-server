package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 项目分类
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
@TableName("diag_classification")
public class DiagClassification extends BaseModel<DiagClassification> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 分类编号
	 */
	private String classNo;
	/**
	 * 分类名称
	 */
	private String className;
	/**
	 * 分类描述
	 */
	private String classDesc;
	/**
	 * 上级分类ID，一级分类为0
	 */
	private Long parentId;
	/**
	 * 排序
	 */
	private Integer orderNum;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                            

}
