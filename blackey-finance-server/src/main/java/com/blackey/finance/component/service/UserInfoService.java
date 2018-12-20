package com.blackey.finance.component.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserInfo;
import com.blackey.finance.dto.bo.UserInfoBo;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.wx.bean.WxEncyptBean;
import me.chanjar.weixin.common.error.WxErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户信息表 UserInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 登录
     * @param request
     * @param code
     * @return
     */
    WxMaJscode2SessionResult login(HttpServletRequest request, String code) throws WxErrorException;

    /**
     * 解密获取微信授权的手机号
     * @return
     */
    WxMaPhoneNumberInfo getPhoneNumber(WxEncyptBean wxEncyptBean);

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    UserInfoBo findByOpenId(String openid);

    /**
     * 通过openid修改Email认证信息
     * @param openId
     */
    void updateUserByOpenid(String openId);

    /**
     * 查询无关系的用户
     */
    PageUtils queryUserWithoutRelation(String openId,Page page);
}

