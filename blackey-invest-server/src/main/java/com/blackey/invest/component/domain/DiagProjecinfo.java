package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息表
 *
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@Getter
@Setter
@TableName("diag_project_info")
public class DiagProjecinfo extends BaseModel<DiagProjecinfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 项目编号
	 */
	private String projectNo;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目简介
	 */
	private String projectBrief;
	/**
	 * 创业者姓名
	 */
	private String entrepreneur;
	/**
	 * 项目详细描述
	 */
	private String projectDesc;
	/**
	 * 微信openid
	 */
	private String openid;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 项目状态（1待审核、2审核通过、3审核拒绝）
	 */
	private Integer status;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 项目套餐编号
	 */
	private String setmeetNo;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                                

}
