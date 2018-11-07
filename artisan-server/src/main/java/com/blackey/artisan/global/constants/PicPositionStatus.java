package com.blackey.artisan.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 图片位置
 *
 * @author blackey
 * @date 2018/11/5
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum PicPositionStatus {

    /**
     * 反馈
     */
    MAIN("首页"),
    DETAIL("详情页");


    private String name;
    private String value;

    PicPositionStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }
}
