package com.blackey.artisan.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *  BO
 * 
 * @author kaven
 * @date 2019-01-02 09:47:38
 */
@Getter
@Setter
public class CommentBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private Integer comment;
	/**
	 * 
	 */
    private Integer serviceStatus;
	/**
	 * 
	 */
    private Integer responseSpeed;

    private String serviceId;

    private List picUrls;
}
