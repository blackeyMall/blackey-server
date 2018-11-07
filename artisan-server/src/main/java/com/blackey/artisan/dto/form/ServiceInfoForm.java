package com.blackey.artisan.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kavenW
 * @date 2018-11-06 13:45:21
 */
@Getter
@Setter
public class ServiceInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

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
