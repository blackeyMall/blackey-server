package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 关注/点赞 或取消
 *
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum AddCancelEnum {

    /**
     * 关注或取消
     */
    ADD("关注"),
    CANCEL("取消");

    private String name;
    private String value;

    AddCancelEnum(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
