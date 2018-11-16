package com.blackey.artisan.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 图片类型
 *
 * @author blackey
 * @date 2018/11/5
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum PicTypeStatus {

    /**
     * 图片类型
     */
    PROCESS("进度图片"),
    FEEDBACK("反馈图片");


    private String name;
    private String value;

    PicTypeStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }
}
