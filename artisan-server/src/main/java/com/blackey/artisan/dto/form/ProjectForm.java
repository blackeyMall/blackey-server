package com.blackey.artisan.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@Getter
@Setter
public class ProjectForm implements Serializable {

    private static final long serialVersionUID = 1L;

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

}
