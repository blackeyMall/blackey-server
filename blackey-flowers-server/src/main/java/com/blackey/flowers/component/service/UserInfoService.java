package com.blackey.flowers.component.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.blackey.flowers.dto.form.UserInfoForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.UserInfo;
import me.chanjar.weixin.common.error.WxErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户信息表 UserInfoService
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);




    /**
     * 微信登录
     * @param request
     * @param form
     * @return
     * @throws WxErrorException
     */
    WxMaJscode2SessionResult login(HttpServletRequest request, UserInfoForm form)  throws WxErrorException;

    /**
     * 登录完成后获取用户信息
     * @param request
     * @param encryptData
     * @param vi
     * @return
     */

    UserInfoForm saveWxUserForm(HttpServletRequest request, String encryptData, String vi);


}

