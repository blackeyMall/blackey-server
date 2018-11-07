package com.blackey.artisan.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-06 13:45:21
 */
@Getter
@Setter
public class ServiceInfoBo implements Serializable {

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
    private String serviceTime;
	/**
	 * 
	 */
    private String address;
	/**
	 * 
	 */
    private String remark;
	/**
	 * 
	 */
    private String telephone;
	/**
	 * 
	 */
    private String name;

}
