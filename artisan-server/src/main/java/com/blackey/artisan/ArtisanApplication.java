package com.blackey.artisan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author blackey
 * @date 2018/11/4
 */
@SpringBootApplication
@MapperScan("com.blackey.artisan.component.mapper")
public class ArtisanApplication {
}
