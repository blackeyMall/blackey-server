package com.blackey.flowers.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
@TableName("t_user_info")
public class UserInfo extends BaseModel<UserInfo> implements Serializable {

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
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String country;
	/**
	 * 
	 */
	private Integer groupId;
	/**
	 * 
	 */
	private String avatarUrl;
	/**
	 * 
	 */
	private String language;
	/**
	 * 
	 */
	private String nickName;
	/**
	 * 
	 */
	private String openId;
	/**
	 * 
	 */
	private String province;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private Integer gender;
	/**
	 * 
	 */
	private String sexDesc;
	/**
	 * 
	 */
	private Long subscribeTime;
	/**
	 * 
	 */
	private String uniqueId;
	/**
	 * 
	 */
	private String telephone;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                                                

}
