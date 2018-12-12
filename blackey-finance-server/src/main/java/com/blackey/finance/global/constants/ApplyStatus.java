package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 *
 * @author blackey
 * @date 2018/12/12
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ApplyStatus {

    /**
     * 待审核
     */
    ADD("关注"),
    CANCEL("取消");

    private String name;
    private String value;

    ApplyStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }

}
