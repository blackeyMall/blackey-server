package com.blackey.gen;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blackey.gen.dao")
public class GeneratorApplication implements CommandLineRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GeneratorApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>[GeneratorApplication start success]<<<<<<<<<<<<<<<<<");
    }
}
