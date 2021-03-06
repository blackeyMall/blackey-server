package com.blackey.artisan.dto.form;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.global.constants.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  Form表单
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@Getter
@Setter
public class OrderForm extends Page {

    private static final long serialVersionUID = 1L;

    private String id;

    private String orderNo;

    private String userId;

    private String projectId;

    private OrderStatus orderStatus;

	private String materialId;

	private Integer price;

	/**
	 * 服务
	 */
	private String serviceTime;

	private String address;

	private String remark;

	private String telephone;

	private String name;

	private String openId;

}
