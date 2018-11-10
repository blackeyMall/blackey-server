package com.blackey.artisan.component.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.component.domain.User;
import com.blackey.artisan.component.mapper.UserMapper;
import com.blackey.artisan.component.service.UserService;
import com.blackey.artisan.dto.form.UserForm;
import com.blackey.artisan.global.config.WxMaConfiguration;
import com.blackey.artisan.global.config.WxMaProperties;
import com.blackey.common.utils.WXUtils;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *  UserServiceImpl
 *
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Resource
    WxMaProperties wxMaProperties;

    @Resource
    UserMapper userMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<User> page = (Page<User>) this.page(
                new Query<User>(params).getPage(),
                new QueryWrapper<User>()
        );

        return new PageUtils(page);
    }



    @Override
    public WxMaJscode2SessionResult login(HttpServletRequest request, UserForm form) throws WxErrorException {

        return WxMaConfiguration.getMaServices().get(wxMaProperties.getConfigs().get(0).getAppid()).getUserService().getSessionInfo(form.getCode());

    }


    @Override
    public UserForm saveWxUserForm(HttpServletRequest request, String encryptData, String vi) {
        Gson gson = new Gson();
        String sessionKey = (String) request.getSession().getAttribute("wxSessionKey");
        User userInfo =  gson.fromJson(WXUtils.decryptWxUser(sessionKey,encryptData,vi),User.class);
        this.save(userInfo);
        return null;
    }


    @Override
    public User findByOpenId(String openId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("open_id",openId);


        return this.getOne(queryWrapper);
    }
}
