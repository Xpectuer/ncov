package com.zjut.azhen.ncov;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjut.azhen.ncov.mapping")
@SpringBootApplication
public class NcovApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcovApplication.class, args);
    }

}
