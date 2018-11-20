package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注项目表
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
@TableName("user_project_follow")
public class UserProjectFollow extends BaseModel<UserProjectFollow> implements Serializable {

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
	 * 用户id
	 */
	private String userId;
	/**
	 * 项目id
	 */
	private String projectId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                

}
