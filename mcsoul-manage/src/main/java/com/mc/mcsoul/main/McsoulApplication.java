package com.mc.mcsoul.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mc.mcsoul.dao.mapper")
@SpringBootApplication
public class McsoulApplication {

    public static void main(String[] args)   {
        SpringApplication.run(McsoulApplication.class, args);
    }

}
