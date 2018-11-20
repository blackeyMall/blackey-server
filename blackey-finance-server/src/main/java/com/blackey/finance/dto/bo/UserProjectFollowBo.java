package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注项目表 BO
 * 
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
public class UserProjectFollowBo implements Serializable {

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
	 * 用户id
	 */
    private String userId;
	/**
	 * 项目id
	 */
    private String projectId;

}
