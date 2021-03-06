package com.blackey.artisan.dto.bo;

import com.blackey.artisan.global.constants.PicTypeStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-07 19:42:29
 */
@Getter
@Setter
public class PictureInfoBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private PicTypeStatus picType;
	/**
	 * 
	 */
    private String picUrl;
	/**
	 * 
	 */
    private String proDesc;

	private String objectId;

}
