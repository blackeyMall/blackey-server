package com.blackey.component.model;

import com.blackey.component.BaseModel;
import com.blackey.global.constant.FileType;
import com.blackey.global.constant.Position;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 图片
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Getter
@Setter
@Entity
@Table(name = "pic")
public class Pic extends BaseModel {

    private String id;

    private String fileName;

    @Enumerated
    private FileType fileType;

    private String url;

    private String domain;

    private String absoluteUrl;

    @Enumerated
    private Position position;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;


}
