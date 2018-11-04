package com.blackey.artisan;

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
@MapperScan("com.blackey.artisan.component.mapper")
public class ArtisanApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        SpringApplication.run(ArtisanApplication.class);
    }
}
