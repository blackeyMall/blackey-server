package com.blackey.flowers.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 * creat_user: kaven
 *
 * @date: 2018/12/5 21:55
 **/
@Getter
@Setter
public class WxCodeForm implements Serializable {

    private String refereeId;

    private String path;
}
