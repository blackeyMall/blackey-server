package com.blackey.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * bbs 启动类
 * @author blackey
 * @date 2018/11/4
 */
@SpringBootApplication
@MapperScan("com.blackey.bbs.component.mapper")
public class BbsApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class);
    }
}
