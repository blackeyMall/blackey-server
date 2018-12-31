package com.blackey.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * shiro 启动类
 * Created by Kaven
 * Date: 2018/6/4
 */
@SpringBootApplication
@MapperScan("com.blackey.admin.component.mapper")
public class ShiroApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroApplication.class);
    @Override
    public void run(String... strings) throws Exception {

        LOGGER.info(">>>>>>>>>>>>[ShiroApplication start success]<<<<<<<<<<<<");
    }

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }

}
