package com.blackey.admin.component.service;

import com.blackey.admin.component.domain.SysCaptcha;
import com.blackey.mybatis.service.BaseService;

import java.awt.image.BufferedImage;

/**
 * 系统验证码 SysCaptchaService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysCaptchaService extends BaseService<SysCaptcha> {

    /**
     * 获取图片验证码
     * @param uuid
     * @return
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(String uuid, String code);
}

