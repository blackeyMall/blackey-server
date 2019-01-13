package com.blackey.moudle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *
 * @author blackey
 * @date 2019/1/8
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {

    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
