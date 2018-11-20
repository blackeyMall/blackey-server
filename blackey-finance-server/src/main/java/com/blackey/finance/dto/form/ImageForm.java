package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片表 Form表单
 * 
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Getter
@Setter
public class ImageForm implements Serializable {

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
	 * 图片类型
	 */
    private String imageType;
	/**
	 * 对象id
	 */
    private String objectId;
	/**
	 * 图片url
	 */
    private String imageUrl;
	/**
	 * 内容
	 */
    private String content;

}
