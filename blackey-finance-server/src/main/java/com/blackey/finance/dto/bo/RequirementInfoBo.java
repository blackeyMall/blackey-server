package com.blackey.finance.dto.bo;

import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.finance.global.constants.AuditStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求信息表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class RequirementInfoBo implements Serializable {

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
    private AuditStatusEnum auditStatus;
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

    private Date createdDate;

	/**
	 * 是否关注标示，add 关注 cancel 未关注
	 */
	private AddCancelEnum isFollow = AddCancelEnum.CANCEL;
	/**
	 * 是否关注标示，add 关注 cancel 未关注
	 */
	private AddCancelEnum isLike = AddCancelEnum.CANCEL;

	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 职位
	 */
	private String duties;


}
