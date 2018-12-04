package com.blackey.flowers.component.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.utils.WXUtils;
import com.blackey.flowers.component.domain.UserInfo;
import com.blackey.flowers.component.mapper.UserInfoMapper;
import com.blackey.flowers.component.service.UserInfoService;
import com.blackey.flowers.dto.bo.WxMobileBo;
import com.blackey.flowers.dto.form.UserInfoForm;
import com.blackey.flowers.dto.form.WxMobileForm;
import com.blackey.flowers.global.config.WxMaConfiguration;
import com.blackey.flowers.global.config.WxMaProperties;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import com.google.gson.Gson;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Watchable;
import java.util.Map;

/**
 * 用户信息表 UserInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


    @Resource
    WxMaProperties wxMaProperties;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserInfo> page = (Page<UserInfo>) this.page(
                new Query<UserInfo>(params).getPage(),
                new QueryWrapper<UserInfo>()
        );

        return new PageUtils(page);
    }


    @Override
    public WxMaJscode2SessionResult login(HttpServletRequest request, UserInfoForm form) throws WxErrorException {
        return WxMaConfiguration.getMaServices().get(wxMaProperties.getConfigs().get(0).getAppid()).getUserService().getSessionInfo(form.getCode());

    }


    @Override
    public UserInfoForm saveWxUserForm(HttpServletRequest request, String encryptData, String vi) {
        Gson gson = new Gson();
        String sessionKey = (String) request.getSession().getAttribute("wxSessionKey");
        UserInfo userInfo =  gson.fromJson(WXUtils.decryptWxUser(sessionKey,encryptData,vi),UserInfo.class);
        this.save(userInfo);
        return null;
    }

    @Override
    public UserInfo findByOpenId(String openId) {

        Wrapper querWrapper = new QueryWrapper();
        ((QueryWrapper) querWrapper).eq("open_id",openId);
        return this.getOne(querWrapper);
    }

    /**
     * 获取微信手机号
     *
     * @param wxMobileForm
     * @return
     */
    @Override
    public String getWxMobile(WxMobileForm wxMobileForm) {

        String wxMobile = WXUtils.decryptWxMobile(wxMobileForm.getEncrypData(),
                wxMobileForm.getSessionKey(), wxMobileForm.getIv());

        JSONObject jsonObject = JSON.parseObject(wxMobile);
        WxMobileBo wxMobileBo = JSON.parseObject(jsonObject.getString("mobile"),WxMobileBo.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setTelephone(wxMobileBo.getPurePhoneNumber());
        this.update(userInfo,new UpdateWrapper<UserInfo>().eq("open_id",wxMobileForm.getOpenId()));

        return wxMobileBo.getPurePhoneNumber();
    }

}
