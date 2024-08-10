package com.example.webpos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.webpos.mapper")
public class WebPosApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebPosApplication.class, args);
  }
}
