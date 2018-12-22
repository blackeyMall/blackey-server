package com.blackey.finance.dto.form;

import com.blackey.finance.dto.BaseSearch;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.CategoryEnum;
import com.blackey.finance.global.constants.OrderbyEnum;
import com.blackey.finance.global.constants.TableCodeEnum;
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
	 * 是否金融发布，1 今日发布  0非今日发布
	 */
	private Integer isTodayPublish = 0;
	/**
	 * 类别
	 */
    private CategoryEnum category = CategoryEnum.PROJECT;
	/**
	 * 排序方式
	 */
    private OrderbyEnum orderbyEnum = OrderbyEnum.DEFAULT;
	/**
	 * 前端table列表
	 */
    private TableCodeEnum tableCode = TableCodeEnum.DEFAULT;
	/**
	 * 图片链接
	 */
	private String[] images;

}
