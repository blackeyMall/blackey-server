package com.blackey.admin.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.admin.component.domain.SysCaptchaEntity;
import com.blackey.admin.component.mapper.SysCaptchaMapper;
import com.blackey.admin.component.service.SysCaptchaService;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 * @since 2.0.0 2018-02-10
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends BaseServiceImpl<SysCaptchaMapper, SysCaptchaEntity> implements SysCaptchaService {
    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {

        //生成文字验证码
        String code = producer.createText();

        SysCaptchaEntity captchaEntity = new SysCaptchaEntity();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addMinutes(new Date(), 5));
        baseMapper.insert(captchaEntity);

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        SysCaptchaEntity captchaEntity = this.getOne(new QueryWrapper<SysCaptchaEntity>().eq("uuid", uuid));
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
