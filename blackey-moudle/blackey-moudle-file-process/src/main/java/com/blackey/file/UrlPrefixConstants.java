package com.blackey.file;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author blackey
 * @date 2019/1/8
 */
@Data
@Component
@ConfigurationProperties(prefix = "blackey.file.upload")
public class UrlPrefixConstants {

    private String serverName;

    private String remoteAddress;

    private String serverDomain;
}
