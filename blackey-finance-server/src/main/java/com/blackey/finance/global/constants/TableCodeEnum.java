package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 需求类别
 *
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum CategoryEnum {

    /**
     * 关注或取消
     */
    PROJECT("找项目"),
    FINANCE("找资金");

    private String name;
    private String value;

    CategoryEnum(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
