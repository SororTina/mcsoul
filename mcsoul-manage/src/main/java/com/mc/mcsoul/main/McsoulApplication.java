package com.mc.mcsoul.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.mc.mcsoul.dao")
@SpringBootApplication(scanBasePackages = "com.mc.mcsoul")
@EnableTransactionManagement
public class McsoulApplication {

    public static void main(String[] args)   {
        SpringApplication.run(McsoulApplication.class, args);
    }

}
