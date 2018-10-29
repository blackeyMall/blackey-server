package com.blackey.component.model;


import com.blackey.component.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * 材料表
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Getter
@Setter
@Entity
@Table(name = "material")
public class Material extends BaseModel{

    private String name;

    private String num;

    private Pic pic;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

}
