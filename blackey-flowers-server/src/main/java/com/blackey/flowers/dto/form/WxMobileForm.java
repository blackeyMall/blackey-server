package com.blackey.flowers.dto.form;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取微信手机号form
 * creat_user: kaven
 *
 * @date: 2018/12/1 20:53
 **/
@Getter
@Setter
public class WxMobileForm {

    private String openId;

    private String encrypData;

    private String iv;

    private String sessionKey;
}
