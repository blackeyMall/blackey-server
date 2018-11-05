package com.blackey.artisan.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
@Getter
@Setter
public class MaterialBo implements Serializable {

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
    private String name;
	/**
	 * 
	 */
    private String picUrl;
	/**
	 * 
	 */
    private String desc;
	/**
	 * 
	 */
    private Integer num;
	/**
	 * 
	 */
    private String projectId;

}
