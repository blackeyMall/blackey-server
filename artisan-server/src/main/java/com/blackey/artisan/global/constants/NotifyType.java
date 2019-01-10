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
public enum NotifyType {

    /**
     * 订单状态
     */
    DEFAULT("全部"),
    ORDER("订单通知");

    private String name;
    private String value;

    NotifyType(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
