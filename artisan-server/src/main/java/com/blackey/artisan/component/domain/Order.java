package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.artisan.global.constants.OrderStatus;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@Getter
@Setter
@TableName("order")
public class Order extends BaseModel<Order> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String orderNo;
	/**
	 * 
	 */
	private String userId;

	private String projectId;

	private OrderStatus status;

	private int price;

	private String remark;


    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
