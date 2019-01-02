package com.blackey.artisan.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *  Form表单
 * 
 * @author kaven
 * @date 2019-01-02 09:47:38
 */
@Getter
@Setter
public class CommentForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private Integer comment;
	/**
	 * 
	 */
    private Integer serviceStatus;
	/**
	 * 
	 */
    private Integer responseSpeed;

	private String[] picUrl;

	private String serviceId;

}
