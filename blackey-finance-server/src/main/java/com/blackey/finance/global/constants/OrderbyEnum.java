package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 排序方式
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum OrderbyEnum {

    /**
     * 对象类型
     */
    DEFAULT("默认"),
    FOLLOWNUM("关注数量"),
    LIKENUM("点赞数量");

    private String name;
    private String value;

    OrderbyEnum(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
