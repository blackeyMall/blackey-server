package com.blackey.finance.global.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 审批状态
 *
 * @author kaven
 * @date 2018/11/26
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum AuditStatusEnum {

    /**
     * 审批状态
     */
    DEFAULT("全部"),
    WAITING("待审批"),
    SUCCESS("审批通过"),
    REFUSE("审批拒绝");

    private String name;
    private String value;

    AuditStatusEnum(String name) {
        this.name = name;
        this.value = this.toString();
    }


}
