package com.blackey.finance.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *  分页查询
 * creat_user: kaven
 *
 * @date: 2018/12/3 11:26
 **/
@Setter
@Getter
public abstract class BaseSearch {

    private long size;
    private long current;
}
