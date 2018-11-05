package com.blackey.invest.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 投资人评价信息 BO
 * 
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
public class DiagEvaluateInfoBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    private Long id;
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
	/**
	 * 逻辑删除
	 */
    private Integer isDeleted;
	/**
	 * 创建人
	 */
    private String createBy;
	/**
	 * 创建时间
	 */
    private Date createDate;
	/**
	 * 更新人
	 */
    private String updateBy;
	/**
	 * 更新时间
	 */
    private Date updateDate;

}
