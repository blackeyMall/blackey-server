package com.blackey.flowers.dto.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信返回手机号对象
 * creat_user: kaven
 *
 * @date: 2018/12/2 08:38
 **/
@Setter
@Getter
public class WxMobileBo {

    private String phoneNumber;

    private String purePhoneNumber;

    private String countryCode;
}
