package com.blackey.admin.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackey.admin.component.domain.SysCaptcha;
import com.blackey.admin.component.mapper.SysCaptchaMapper;
import com.blackey.admin.component.service.SysCaptchaService;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * 系统验证码 SysCaptchaServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysCaptchaServiceImpl extends BaseServiceImpl<SysCaptchaMapper, SysCaptcha> implements SysCaptchaService {

    private static final Logger logger = LoggerFactory.getLogger(SysCaptchaServiceImpl.class);

    @Autowired
    private Producer producer;

    /**
     * 获取图片验证码
     *
     * @param uuid
     * @return
     */
    @Override
    public BufferedImage getCaptcha(String uuid) {
        //生成文字验证码
        String code = producer.createText();

        SysCaptcha captchaEntity = new SysCaptcha();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addMinutes(new Date(), 5));
        baseMapper.insert(captchaEntity);

        return producer.createImage(code);
    }

    /**
     * 验证码效验
     *
     * @param uuid uuid
     * @param code 验证码
     * @return true：成功  false：失败
     */
    @Override
    public boolean validate(String uuid, String code) {
        SysCaptcha captchaEntity = this.getOne(new QueryWrapper<SysCaptcha>().eq("uuid", uuid));
        if(captchaEntity == null){
            return false;
        }
        //删除验证码
        this.removeById(uuid);
        if(captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
}
