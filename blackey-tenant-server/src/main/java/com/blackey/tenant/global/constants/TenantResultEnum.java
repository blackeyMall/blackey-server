package com.blackey.tenant.global.constants;

import com.blackey.common.result.ResultCode;

/**
 * 多租户系统返回结果枚举
 * @author wangwei : kaven
 *
 * @date: 2019/1/3 14:02
 **/
public enum TenantResultEnum implements ResultCode {

    /**
     * 多租户系统返回结果枚举
     */
    PASSWORD_UPDATE_ERROR(400001,"原密码不正确"),
    CURRENT_USER_DEL_ERROR(400002,"当前用户不能删除"),
    SUPER_USER_DEL_ERROR(400003,"系统管理员不能删除"),
    CAPTCHA_VALID_ERROR(400004,"验证码错误"),
    PASSWORD_ACCOUNT_ERROR(400005,"用户名或密码错误"),
    USER_UNENABLE_ERROR(400006,"用户被禁用，请联系管理员"),
    EXIST_CHILD_DEPT(400007,"存在子部门，请先删除对应的子菜单")


    ;


    private int code;
    private String msg;

    TenantResultEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
