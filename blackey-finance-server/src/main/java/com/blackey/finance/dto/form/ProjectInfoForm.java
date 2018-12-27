package com.blackey.finance.dto.form;

import com.blackey.finance.dto.BaseSearch;
import com.blackey.finance.global.constants.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class ProjectInfoForm extends BaseSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
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
    private AuditStatusEnum auditStatus = AuditStatusEnum.WAITING;
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
    private ProjectCategoryEnum category = ProjectCategoryEnum.STOCK;
	/**
	 * 排序方式
	 */
	private OrderbyEnum orderbyEnum = OrderbyEnum.DEFAULT;
	/**
	 * 前端table列表
	 */
	private TableCodeEnum tableCode = TableCodeEnum.DEFAULT;



}
