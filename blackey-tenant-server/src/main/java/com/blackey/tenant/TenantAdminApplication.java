package com.blackey.tenant;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 多租户后台管理系统启动类
 * @author : kaven
 *
 * @date: 2018/12/31 17:28
 **/
@SpringBootApplication
@MapperScan("com.blackey.tenant.component.mapper")
public class TenantAdminApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TenantAdminApplication.class);
    @Override
    public void run(String... strings) throws Exception {

        LOGGER.info(">>>>>>>>>>>>[TenantAdminApplication start success]<<<<<<<<<<<<");
    }

    public static void main(String[] args) {
        SpringApplication.run(TenantAdminApplication.class, args);
    }

}
