package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户好友关联表 BO
 * 
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
public class UserRelationBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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
    private String userId;
	/**
	 * 
	 */
    private String friendId;
	/**
	 * 申请状态
	 */
    private String status;

}
