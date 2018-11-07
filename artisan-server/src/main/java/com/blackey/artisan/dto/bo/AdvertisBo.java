package com.blackey.artisan.dto.bo;

import com.blackey.artisan.global.constants.PicPositionStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-07 09:50:15
 */
@Getter
@Setter
public class AdvertisBo implements Serializable {

    private static final long serialVersionUID = 1L;


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
    private Integer adsRemark;
	/**
	 * 
	 */
    private String adsOrder;
	/**
	 * 
	 */
    private String redirectUrl;

}
