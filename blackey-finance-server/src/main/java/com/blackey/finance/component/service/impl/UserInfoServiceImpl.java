package com.blackey.finance.component.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.blackey.finance.dto.bo.UserInfoBo;
import com.blackey.finance.dto.form.UserInfoForm;
import com.blackey.finance.global.config.WxMaConfiguration;
import com.blackey.finance.global.config.WxMaProperties;
import com.blackey.wx.bean.WxEncyptBean;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserInfoMapper;
import com.blackey.finance.component.domain.UserInfo;
import com.blackey.finance.component.service.UserInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户信息表 UserInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    WxMaProperties wxMaProperties;

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserInfo> page = (Page<UserInfo>) this.page(
                new Query<UserInfo>(params).getPage(),
                new QueryWrapper<UserInfo>()
        );

        return new PageUtils(page);
    }

    @Override
    public WxMaJscode2SessionResult login(HttpServletRequest request, String code) throws WxErrorException {
        return WxMaConfiguration.getMaServices().get(wxMaProperties.getConfigs().get(0).getAppid()).getUserService().getSessionInfo(code);
    }

    @Override
    public WxMaPhoneNumberInfo getPhoneNumber(WxEncyptBean wxEncyptBean) {
        return WxMaConfiguration.getMaServices().get(wxMaProperties.getConfigs()
                .get(0).getAppid()).getUserService().getPhoneNoInfo(
                        wxEncyptBean.getWxSessionKey(),
                        wxEncyptBean.getEncryptData(),
                        wxEncyptBean.getIv());
    }


    @Override
    public UserInfoBo findByOpenId(String openid) {
        return userInfoMapper.findByOpenid(openid);
    }

    @Override
    public void updateUserByOpenid(String openId) {
        userInfoMapper.updateByOpenid(openId);

    }
}
