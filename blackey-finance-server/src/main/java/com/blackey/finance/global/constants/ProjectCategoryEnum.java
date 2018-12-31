package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 项目类别
 *
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ProjectCategoryEnum {

    /**
     * 项目类别
     */
    DEFAULT("全部"),
    STOCK("股权项目"),
    OTHER("其他项目");

    private String name;
    private String value;

    ProjectCategoryEnum(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
