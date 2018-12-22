package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 前段table页面
 *
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum TableCodeEnum {

    /**
     * 前端table页面
     */
    DEFAULT("全部"),
    TODAY_PUBLISH("今日发布"),
    RECOMMEND("精品"),
    MY_FOLLOW("我的关注"),
    MY_CREATE("我的");

    private String name;
    private String value;

    TableCodeEnum(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
