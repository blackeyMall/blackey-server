package com.blackey.flowers.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
@Getter
@Setter
public class RefereeInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 推荐人姓名
	 */
    private String name;
	/**
	 * 渠道来源
	 */
    private String channel;

}
