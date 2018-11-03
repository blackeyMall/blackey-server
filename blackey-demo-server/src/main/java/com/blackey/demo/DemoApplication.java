package com.blackey.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO 描述
 *
 * @author wangwei
 * @date 2018/11/2
 */
@SpringBootApplication
@MapperScan("com.blackey.demo.mapper")
public class DemoApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    @Override
    public void run(String... strings) throws Exception {

        LOGGER.info(">>>>>>>>>>>>[DemoApplication start success]<<<<<<<<<<<<");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
