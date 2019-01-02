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
public enum NotifyStatus {

    /**
     * 订单状态
     */
    DEFAULT("全部"),
    NOTIFY("可以通知"),
    NOTIFYED("已通知");

    private String name;
    private String value;

    NotifyStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
