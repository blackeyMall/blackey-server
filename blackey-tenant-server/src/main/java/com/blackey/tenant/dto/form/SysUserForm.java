package com.blackey.tenant.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户信息form
 * @author : kaven
 *
 * @date: 2019/1/2 13:51
 **/
@Setter
@Getter
public class SysUserForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private long size = 10;

    private long current = 1;

    private String userName;

    private long createUserId;
}
