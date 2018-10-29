package com.blackey.global.constant;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 文件类型
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  FileType {


    /**
     * 主图
     */
    Main("主图"),

    /**
     * 缩略图
     */
    Thumbnail("缩略图")
    ;

    private String name;

    private String value;

    FileType(String name) {
        this.name = name;
        this.value = this.toString();
    }
}
