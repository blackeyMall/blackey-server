package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 项目信息表
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
@TableName("t_project_info")
public class ProjectInfo extends BaseModel<ProjectInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 项目名称
	 */
	private String name;
	/**
	 * 项目简介
	 */
	private String brief;
	/**
	 * 项目logo
	 */
	private String logo;
	/**
	 * 点赞数量
	 */
	private Integer likeNum;
	/**
	 * 关注数量
	 */
	private Integer followNum;
	/**
	 * 用户id
	 */
	private String openId;
	/**
	 * 认证状态
	 */
	private AuditStatusEnum auditStatus;
	/**
	 * 是否精品
	 */
	private String isRecommend;
	/**
	 * 标签
	 */
	private String label;
	/**
	 * 融资金额
	 */
	private String financeAmount;
	/**
	 * 融资阶段
	 */
	private String financeRound;
	/**
	 * 类别
	 */
	private String category;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                

}
