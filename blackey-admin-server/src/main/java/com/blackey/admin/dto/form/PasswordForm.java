package com.blackey.admin.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 密码表单
 *
 * @author kavenW
 * @since 1.4.0 2018-01-25
 */
@Setter
@Getter
public class PasswordForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;


}
