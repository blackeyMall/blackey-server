package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.email.service.EmailService;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.finance.component.service.UserInfoService;
import com.blackey.finance.dto.bo.UserInfoBo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 邮件验证发送
 *
 * @author blackey
 * @date 2018/12/17
 */
@RestController
@RequestMapping("/finance/email")
public class EmailSenderRest extends BaseRest{


    @Resource
    private HttpServletResponse response;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private EmailService emailService;

    @RequestMapping("/send")
    public Result sendEmail(@RequestBody ProjectInfoForm form){
        String pid = form.getId();
        String openid = form.getOpenId();
        String domain = "https://www.ssqushe.com/finance/email/callback";

        String contentUrl = domain + "?p=" + pid + "&o=" + openid;
        String subject =  "金融圈BP上传邮件";

        UserInfoBo userInfoBo = userInfoService.findByOpenId(openid);

        emailService.sendSimpleEmail(userInfoBo.getEmail(),subject,contentUrl);
        return success();
    }

    @RequestMapping("/callback")
    public void callback(@RequestParam ProjectInfoForm form) throws IOException {
        userInfoService.updateUserByOpenid(form.getOpenId());
        response.sendRedirect("");
    }
}
