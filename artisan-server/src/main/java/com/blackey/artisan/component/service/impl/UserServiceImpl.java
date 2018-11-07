package com.blackey.artisan.component.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.blackey.artisan.dto.form.UserForm;
import com.blackey.common.utils.WXUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.UserMapper;
import com.blackey.artisan.component.domain.User;
import com.blackey.artisan.component.service.UserService;

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

    WxMaService wxMaService;

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

        WxMaJscode2SessionResult result = this.wxMaService.getUserService().getSessionInfo(form.getCode());
        String sessionKey = result.getSessionKey();
        Gson gson = new Gson();
        String resultStr = WXUtils.decryptWxUser(form.getEncrypData(),sessionKey,form.getIv());

        String userJson = gson.fromJson(resultStr, JsonObject.class).get("userInfo").getAsString();
        User userInfo =  gson.fromJson(userJson,User.class);

        User userInfoDb = userMapper.queryByOpenid(userInfo.getOpenId());

        if (userInfoDb == null){
            log.info("get user info is null... create a new one!");
            this.save(userInfo);
        }

        return result;

    }


    @Override
    public UserForm saveWxUserForm(HttpServletRequest request, String encryptData, String vi) {
        Gson gson = new Gson();
        String sessionKey = (String) request.getSession().getAttribute("wxSessionKey");
        User userInfo =  gson.fromJson(WXUtils.decryptWxUser(sessionKey,encryptData,vi),User.class);
        this.save(userInfo);
        return null;
    }

}
