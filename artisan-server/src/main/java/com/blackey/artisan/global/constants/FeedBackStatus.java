package com.blackey.artisan.global.constants;

/**
 * 反馈
 *
 * @author blackey
 * @date 2018/11/5
 */
public enum FeedBackStatus {

    /**
     * 反馈
     */
    BYUSER("实时反馈"),
    AFTERSALES("售后反馈");


    private String name;
    private String value;

    FeedBackStatus(String name) {
        this.name = name;
        this.value = this.toString();
    }
}
