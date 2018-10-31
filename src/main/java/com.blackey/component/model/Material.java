package com.blackey.component.model;


import com.blackey.jpa.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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
public class Material extends BaseModel {

    private String name;

    private String num;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "material")
    private List<Pic> pic;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

}
