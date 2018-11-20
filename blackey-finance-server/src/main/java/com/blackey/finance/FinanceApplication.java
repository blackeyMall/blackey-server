package com.blackey.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author blackey
 * @date 2018/11/4
 */
@SpringBootApplication
@MapperScan("com.blackey.finance.component.mapper")
public class FinanceApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class);
    }
}
