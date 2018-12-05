package com.blackey.flowers.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
@Getter
@Setter
public class RefereeInfoBo implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;
	/**
	 * 推荐人姓名
	 */
    private String name;
	/**
	 * 渠道来源
	 */
    private String channel;
	/**
	 * 订单数量
	 */
    private int orderNum;

}
