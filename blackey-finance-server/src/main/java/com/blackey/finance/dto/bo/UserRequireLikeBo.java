package com.blackey.finance.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户需求点赞表 BO
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserRequireLikeBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
    private String openId;
	/**
	 * 需求id
	 */
    private String requireId;
	/**
	 * 备注
	 */
    private String remark;

}
