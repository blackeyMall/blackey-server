package com.blackey.bbs.global.config;

import com.blackey.common.exception.FilterException;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 统一错误页面配置
 * @author wangwei : kaven
 *
 * @date: 2019/1/4 14:16
 **/
@Configuration
public class ErrorPageConfig {


    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {

                /**
                 * 可扩展
                 */
                ErrorPage serverErrorPage = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/sys/error/500");
                ErrorPage filterErrorPage = new ErrorPage(FilterException.class,"/sys/error/401");

                factory.addErrorPages(serverErrorPage,filterErrorPage);

            }
        };
    }
}
