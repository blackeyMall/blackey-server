package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

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
	 * 主键id
	 */
	@TableId
	private Long id;
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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
