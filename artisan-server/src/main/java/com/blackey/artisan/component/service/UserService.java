package com.blackey.artisan.component.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.blackey.artisan.dto.form.UserForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.User;
import me.chanjar.weixin.common.error.WxErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *  UserService
 *
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
public interface UserService extends BaseService<User> {

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
    WxMaJscode2SessionResult login(HttpServletRequest request, UserForm form)  throws WxErrorException;

    /**
     * 登录完成后获取用户信息
     * @param request
     * @param encryptData
     * @param vi
     * @return
     */
    UserForm saveWxUserForm(HttpServletRequest request, String encryptData, String vi);
}

