package com.blackey.bbs.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通用配置
 *
 * @author ruoyi
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer
{

    public static final String INTERCEPTOR_ROOT_URI = "/**";
    final String[] notLoginInterceptPaths = {"/META-INF/resources/**", "/resources/**", "/static/**", "/public/**"};
    final String[] notLoginInterceptPaths2 = {"classpath:/META-INF/resources/**", "classpath:/resources/**", "classpath:/static/**", "classpath:/public/**"};



    /**
     * 默认首页的设置，当输入域名是可以自动跳转到默认指定的网页
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("forward:" + "index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /** swagger配置 */
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }


}