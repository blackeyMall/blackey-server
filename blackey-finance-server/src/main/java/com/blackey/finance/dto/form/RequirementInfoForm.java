package com.blackey.finance.dto.form;

import com.blackey.finance.dto.BaseSearch;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.OrderbyEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求信息表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class RequirementInfoForm extends BaseSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
	/**
	 * 需求名称
	 */
    private String title;
	/**
	 * 需求内容
	 */
    private String content;
	/**
	 * 标签
	 */
    private String label;
	/**
	 * 点赞数量
	 */
    private Integer likeNum;
	/**
	 * 附件地址
	 */
    private String attachment;
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
	 * 红包
	 */
    private String redPaper;
	/**
	 * 是否精品
	 */
    private String isRecommend;
	/**
	 * 类别
	 */
    private String category;
	/**
	 * 排序方式
	 */
    private OrderbyEnum orderbyEnum = OrderbyEnum.DEFAULT;

}
