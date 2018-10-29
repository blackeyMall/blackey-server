package com.blackey.component.model;

import com.blackey.component.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseModel {

    /**
     * 微信OpenId
     */
    private String openId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别描述
     */
    private String sexDesc;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 语言
     */
    private String language;
    /**
     * 城市
     */
    private String city;
    /**
     * 省份
     */
    private String province;
    /**
     * 国家
     */
    private String country;
    /**
     * 头像
     */
    private String headImgUrl;
    /**
     * 描述时间
     */
    private Long subscribeTime;
    /**
     * union id
     */
    private String unionId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 分组id
     */
    private Integer groupId;


    @OneToOne(mappedBy = "user")
    private OrderInfo orderInfo;
}
