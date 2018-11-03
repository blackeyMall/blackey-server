package com.blackey.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 系统验证码
 * @author Mark sunlightcs@gmail.com
 * @since 2.0.0 2018-02-10
 */
@Data
@TableName("sys_captcha")
public class SysCaptchaEntity extends Model<SysCaptchaEntity> {

    private String uuid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private Date expireTime;

}
