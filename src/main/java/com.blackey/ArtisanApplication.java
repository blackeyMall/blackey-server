package com.blackey;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Slf4j
@SpringBootApplication
public class ArtisanApplication implements CommandLineRunner{


    @Override
    public void run(String... args) throws Exception {
        log.info("Artisan Application is running!");
    }

    public static void main(String[] args) {
        SpringApplication.run(ArtisanApplication.class);
    }
}
