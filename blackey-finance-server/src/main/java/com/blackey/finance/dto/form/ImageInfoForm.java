package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:48:53
 */
@Getter
@Setter
public class ImageInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 图片类型
	 */
    private String imageType;
	/**
	 * 对象id
	 */
    private String objectId;
	/**
	 * 图片url
	 */
    private String imageUrl;
	/**
	 * 内容
	 */
    private String content;

}
