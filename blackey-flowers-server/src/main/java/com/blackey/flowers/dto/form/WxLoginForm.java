package com.blackey.flowers.dto.form;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信登陆form
 * creat_user: kaven
 *
 * @date: 2018/11/26 09:51
 **/
@Getter
@Setter
public class WxLoginForm {


    private String code;

    private String encrypData;

    private String iv;

    private String wxSessionKey;
}
