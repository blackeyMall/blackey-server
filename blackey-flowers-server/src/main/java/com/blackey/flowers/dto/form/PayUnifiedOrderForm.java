package com.blackey.flowers.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统一下单form
 * @author : kaven
 *
 * @date: 2018/12/2 12:29
 **/
@Getter
@Setter
public class PayUnifiedOrderForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String openId;

    private String goodsNo;

    private String goodsName;

    private String goodsDesc;

    /**
     * 0 一周一次  1 三周三次
     */
    private String goodsType;
    /**
     * 总金额
     */
    private int totalFee;


}
