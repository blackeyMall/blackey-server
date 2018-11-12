package com.blackey.artisan.dto.form;

import com.blackey.artisan.global.constants.PicPositionStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kavenW
 * @date 2018-11-07 09:50:15
 */
@Getter
@Setter
public class AdvertisForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private String id;
	/**
	 * 
	 */
    private PicPositionStatus picPosition;
	/**
	 * 
	 */
    private String picUrl;
	/**
	 * 
	 */
    private String adsRemark;
	/**
	 * 
	 */
    private String adsOrder;
	/**
	 * 
	 */
    private String redirectUrl;

}
