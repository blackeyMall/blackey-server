package com.blackey.artisan.dto.bo;

import com.blackey.artisan.global.constants.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 *
 * @author blackey
 * @date 2018/11/6
 */
@Getter
@Setter
public class OrderInfoDetailBo {

    private String id;

    private Date createdDate;

    private String orderNo;

    private String userId;

    private String projectId;

    private OrderStatus orderStatus;

    private int price;

    private String projectName;

    private String picUrl;

    private String desc;

    private String address;

    private String serviceUserName;

    private String remark;

    private String telephone;

    private String serviceTime;


}
