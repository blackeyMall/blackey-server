package com.blackey.artisan.dto.bo;

import com.blackey.artisan.component.domain.PictureInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */
@Getter
@Setter
public class ServiceProcessBo implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;

    private String content;
	/**
	 * 
	 */
	private String orderId;


	private List<String> pics;
}
