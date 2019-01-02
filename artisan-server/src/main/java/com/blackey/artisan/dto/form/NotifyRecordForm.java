package com.blackey.artisan.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
@Getter
@Setter
public class NotifyRecordForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private String notifyContent;
	/**
	 * 
	 */
    private String notifyUserOpenid;
	/**
	 * 
	 */
    private String notifyUserName;
	/**
	 * 
	 */
    private String notifyType;
	/**
	 * 
	 */
    private String notifyStatus;

}
