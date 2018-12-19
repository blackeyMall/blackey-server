package com.blackey.finance.global.constants;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author blackey
 * @date 2018/12/19
 */
@Configuration
@Setter
@Getter
public class EmailConstant {

    @Value("${http.domain.base}")
    public String domain;

    public String emailContent = "%s,你好:\n\t请点击以下链接上传您的BP文件\n\t" +
            "%s/finance/email/callback" + "?p=%s&o=%s";

    public String subject = "金融圈BP上传专用链接";


}
