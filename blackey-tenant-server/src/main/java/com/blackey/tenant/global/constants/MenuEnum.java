package com.blackey.tenant.global.constants;
import com.blackey.common.result.ResultCode;

/**
 * 菜单enum
 * @author wangwei
 * @date : 2018/6/4
 */
public enum MenuEnum implements ResultCode {

    /**
     * 菜单类型
     */
    CATALOG(0,"目录"),
    MENU(1,"菜单"),
    BUTTON(2,"按钮"),

    /**
     * 是否系统菜单
     */
    SYS_MENU_NO(0,"否"),
    SYS_MENU_YES(1,"是"),

    /**
     * 菜单类型校验
     */
    VALIDATE_SYSTEM_MENU(400011,"系统菜单，不能删除"),
    EXIST_CHILD_MENU(400012,"存在子菜单，请先删除对应的子菜单"),
    /**
     * 菜单类型校验
     */
    VALIDATE_MENU(400010,"上级菜单只能为目录类型"),
    VALIDATE_BUTTON(400010,"上级菜单只能为菜单类型");


    private int code;
    private String msg;

    MenuEnum(int code, String msg){
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
