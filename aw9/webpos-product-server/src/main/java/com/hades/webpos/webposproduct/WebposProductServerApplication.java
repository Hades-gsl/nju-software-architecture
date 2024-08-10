package com.hades.webpos.webposproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@MapperScan("com.hades.webpos.webposproduct.mapper")
public class WebposProductServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebposProductServerApplication.class, args);
  }
}
