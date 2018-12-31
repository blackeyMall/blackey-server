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
     * 通过，拒绝，待同意
     */
    DEFAULT("全部"),
    ACCEPT("通过"),
    REFUSE("取消"),
    APPLY("待同意");

    private String name;
    private String value;

    ApplyStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }

}
