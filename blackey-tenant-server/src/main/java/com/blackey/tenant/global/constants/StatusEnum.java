package com.blackey.tenant.global.constants;

import com.blackey.common.result.ResultCode;

/**
 * 状态
 * @author : kaven
 *
 * @date: 2018/12/18 15:28
 **/
public enum StatusEnum implements ResultCode {

    SATUS_EANBLE(1,"正常"),
    SATUS_DISABLE(0,"禁用");


    private int code;
    private String msg;

    StatusEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
