package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 对象类型
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ObjectTypeEnum {

    /**
     * 对象类型
     */
    DEFAULT("全部"),
    REQUIRE("需求"),
    PROJECT("项目"),
    ACCOUNT("出账流水");

    private String name;
    private String value;

    ObjectTypeEnum(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
