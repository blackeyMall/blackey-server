package com.blackey.flowers.rest;

import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.flowers.component.domain.UserInfo;
import com.blackey.flowers.component.service.UserInfoService;
import com.blackey.flowers.dto.form.UserInfoForm;
import com.blackey.flowers.dto.form.WxMobileForm;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信登陆
 * creat_user: kaven
 *
 * @date: 2018/11/26 09:32
 **/
@RequestMapping("/flowers/wx")
@RestController
public class WxMpController extends BaseRest {


    @Autowired
    private UserInfoService userInfoService;


    @PostMapping("/login")
    public Result login(@RequestBody UserInfoForm form, HttpServletRequest request){
        try {
            return success(userInfoService.login(request,form));
        } catch (WxErrorException e){
            return failure(e.getMessage());
        }
    }

    /**
     * 修改
     */
    @PostMapping("/mobile")
    public Result update(@RequestBody WxMobileForm wxMobileForm){

        String wxMobile = userInfoService.getWxMobile(wxMobileForm);


        return success(wxMobile);
    }
}
