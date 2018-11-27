package com.blackey.flowers.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 支付状态
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum PayStatus {

    /**
     * 订单状态
     */
    DEFAULT("待支付"),
    OK("支付完成"),
    FAILURE("支付失败"),
    REFUND("退款中"),
    REFUND_FINISHED("退款完成");

    private String name;
    private String value;

    PayStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
