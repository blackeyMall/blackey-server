package com.blackey.component.model;


import com.blackey.component.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 订单
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Getter
@Setter
@Entity
@Table(name = "order_info")
public class OrderInfo extends BaseModel {

    private String orderNo;

    @OneToOne()
    @JoinColumn(name = "user")
    private User user;

    @OneToOne
    @JoinColumn(name = "project")
    private Project project;
}
