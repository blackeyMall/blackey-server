package com.blackey.flowers.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 订单状态
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum  OrderStatus{

    /**
     * 订单状态
     */
    DEFAULT("全部"),
    WAIT_PAY("待付款"),
    SERVICE("服务中"),
    DONE("已完成");

    private String name;
    private String value;

    OrderStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
