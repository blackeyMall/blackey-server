package com.blackey.flowers.dto.form;

import com.blackey.flowers.global.constants.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 订单状态变更form
 * creat_user: kaven
 *
 * @date: 2018/12/4 17:34
 **/
@Setter
@Getter
public class OrderStatusChangeForm implements Serializable {

    private String orderNo;

    private OrderStatus orderStatus;
}
