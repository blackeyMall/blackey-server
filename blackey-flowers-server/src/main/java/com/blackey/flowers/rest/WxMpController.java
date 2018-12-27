package com.blackey.flowers.rest;

import cn.binarywang.wx.miniapp.api.WxMaQrcodeService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.flowers.component.domain.UserInfo;
import com.blackey.flowers.component.service.UserInfoService;
import com.blackey.flowers.dto.form.UserInfoForm;
import com.blackey.flowers.dto.form.WxCodeForm;
import com.blackey.flowers.dto.form.WxMobileForm;
import com.blackey.flowers.global.config.WxMaConfiguration;
import com.blackey.flowers.global.config.WxMaProperties;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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

    @Resource
    WxMaProperties wxMaProperties;


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
    /**
     * 生成二维码
     */
    @PostMapping("/getWXCode")
    public void getWXACode(@RequestBody WxCodeForm wxCodeForm,HttpServletResponse response)throws WxErrorException {

        InputStream fis = null;
        OutputStream out = null;
        try {

            WxMaService qrcodeHandler = WxMaConfiguration.getMaServices().get(wxMaProperties.getConfigs().get(0).getAppid());
            WxMaQrcodeService qrcodeService = qrcodeHandler.getQrcodeService();

            File wxaCodeUnlimit = qrcodeService.createWxaCodeUnlimit("refereeId="+wxCodeForm.getRefereeId(), wxCodeForm.getPath());
            fis = new BufferedInputStream(new FileInputStream(wxaCodeUnlimit));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("flowers".getBytes("utf-8"),"ISO-8859-1"));
            response.addHeader("Content-Length", "");
            out = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("image/gif");
            out.write(buffer);
            out.flush();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }finally {
            if(fis != null){
                try {
                    fis.close();
                }catch (Exception e){

                }
            }
            if(out != null){
                try {
                    out.close();
                }catch (Exception e){

                }
            }


        }
    }
}
