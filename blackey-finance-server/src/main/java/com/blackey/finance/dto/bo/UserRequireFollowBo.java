package com.blackey.finance.dto.bo;

import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.finance.global.constants.AuditStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户需求关注表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserRequireFollowBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
    private String openId;
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
	 * 备注
	 */
    private String remark;

	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;

	/**
	 * add 关注该需求
	 */
	private AddCancelEnum isAdd = AddCancelEnum.ADD;

}
