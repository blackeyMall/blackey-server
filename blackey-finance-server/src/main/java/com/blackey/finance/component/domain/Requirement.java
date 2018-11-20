package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求信息表
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
@TableName("requirement")
public class Requirement extends BaseModel<Requirement> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private Integer isDeleted;
	/**
	 * 
	 */
	private String createdBy;
	/**
	 * 
	 */
	private Date createdDate;
	/**
	 * 
	 */
	private String updatedBy;
	/**
	 * 
	 */
	private Date updatedDate;
	/**
	 * 需求名称
	 */
	private String titile;
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
	private String userId;
	/**
	 * 认证状态
	 */
	private String auditStatus;
	/**
	 * 红包
	 */
	private String redPaper;
	/**
	 * 是否精品
	 */
	private String isRecommend;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                                

}
