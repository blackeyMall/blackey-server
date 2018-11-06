package com.blackey.artisan.dto.bo;

import com.blackey.artisan.global.constants.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@Getter
@Setter
public class OrderBo implements Serializable {

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
    private String orderNo;
	/**
	 * 
	 */
    private String userId;
	/**
	 * 
	 */
    private String projectId;

    private OrderStatus OrderStatus;
}
