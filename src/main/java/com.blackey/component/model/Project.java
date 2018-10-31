package com.blackey.component.model;

import com.blackey.jpa.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project extends BaseModel {

    private String id;

    private String name;

    private String proDesc;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "project")
    private List<Pic> pic;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "project")
    private List<Material> materials = new ArrayList<>();

    @OneToOne(mappedBy = "project")
    private OrderInfo orderInfo;
}
