package com.blackey.artisan.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 订单状态
 *
 * @author blackey
 * @date 2018/11/5
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum  OrderStatus {

    /**
     * 订单状态
     */
    BOOK("预约中"),
    CONFIRM("确认中"),
    CONFIRMED("已确认"),
    SERVICE("服务中"),
    DONE("已完成");

    private String name;
    private String value;

    OrderStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
