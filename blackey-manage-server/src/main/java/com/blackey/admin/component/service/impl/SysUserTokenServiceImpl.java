package com.blackey.admin.component.service.impl;

import com.blackey.admin.global.shiro.TokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysUserTokenMapper;
import com.blackey.admin.component.domain.SysUserToken;
import com.blackey.admin.component.service.SysUserTokenService;

import java.util.Date;
import java.util.Map;

/**
 * 系统用户Token SysUserTokenServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysUserTokenServiceImpl extends BaseServiceImpl<SysUserTokenMapper, SysUserToken> implements SysUserTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserTokenServiceImpl.class);

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;


    @Override
    public SysUserToken createToken(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        SysUserToken tokenEntity = this.getById(userId);
        if(tokenEntity == null){
            tokenEntity = new SysUserToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            this.save(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            this.updateById(tokenEntity);
        }

        return tokenEntity;
    }

    @Override
    public void logout(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //修改token
        SysUserToken tokenEntity = new SysUserToken();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }

}
