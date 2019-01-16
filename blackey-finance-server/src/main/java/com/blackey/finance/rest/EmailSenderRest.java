package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.email.service.EmailService;
import com.blackey.finance.component.service.UserInfoService;
import com.blackey.finance.dto.bo.UserInfoBo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.finance.global.constants.EmailConstant;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/finance/email")
public class EmailSenderRest extends BaseRest{


    @Resource
    private HttpServletResponse response;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private EmailService emailService;

    @Resource
    private EmailConstant emailConstant;



    @RequestMapping("/send")
    public Result sendEmail(@RequestBody ProjectInfoForm form){
        String pid = form.getId();
        String openid = form.getOpenId();

        UserInfoBo userInfoBo = userInfoService.findByOpenId(openid);
        if (userInfoBo == null){
            return failure();
        }
        String content = String.format(emailConstant.emailContent
                ,userInfoBo.getName(),emailConstant.getDomain(),pid,openid);

        log.info("email content is [{}]",content);
        emailService.sendSimpleEmail(userInfoBo.getEmail(),emailConstant.getSubject(), content);
        return success();
    }

    @RequestMapping("/callback")
    public void callback(ProjectInfoForm form) throws IOException {
        userInfoService.updateUserByOpenid(form.getOpenId());
        response.sendRedirect("/u.html");
    }
}
