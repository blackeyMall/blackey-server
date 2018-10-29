package com.blackey.global.constant;



/**
 * 位置
 *
 * @author : blackey
 * @date : 2018/10/29
 */
public enum  Position {

    /**
     * 首页
     */
    MainHeadPage("首页Banner"),
    MainPage("首页活动图"),
    ;


    private String name;

    private String value;

    Position(String name) {
        this.name = name;
        this.value = this.toString();
    }
}
