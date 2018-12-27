package com.blackey.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * admin 启动类
 * @author  Kaven
 * @date : 2018/6/4
 */
@SpringBootApplication
@MapperScan("com.blackey.admin.component.mapper")
public class AdminApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminApplication.class);
    @Override
    public void run(String... strings) throws Exception {

        LOGGER.info(">>>>>>>>>>>>[AdminApplication start success]<<<<<<<<<<<<");
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
