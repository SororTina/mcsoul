package com.mc.mcsoul.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.mc.mcsoul.dao")
@SpringBootApplication(scanBasePackages = "com.mc.mcsoul")
public class McsoulApplication {

    public static void main(String[] args)   {
        SpringApplication.run(McsoulApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
