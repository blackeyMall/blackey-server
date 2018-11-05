package com.blackey.artisan.dto.form;

import com.blackey.artisan.global.constants.FeedBackStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kavenW
 * @date 2018-11-05 11:01:32
 */
@Getter
@Setter
public class FeedbackForm implements Serializable {

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
    private String content;
	/**
	 * 
	 */
    private String userId;
	/**
	 * 
	 */
    private String projectId;

	private String picUrl;
	/**
	 * 
	 */
    private FeedBackStatus feedBackType;

}
