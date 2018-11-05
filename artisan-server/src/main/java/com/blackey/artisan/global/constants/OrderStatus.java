package com.blackey.artisan.global.constants;

/**
 * 订单状态
 *
 * @author blackey
 * @date 2018/11/5
 */
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
