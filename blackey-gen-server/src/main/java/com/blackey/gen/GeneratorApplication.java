package com.blackey.gen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
