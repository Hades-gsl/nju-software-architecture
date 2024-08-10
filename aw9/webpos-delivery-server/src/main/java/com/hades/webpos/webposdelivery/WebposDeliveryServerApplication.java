package com.hades.webpos.webposdelivery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hades.webpos.webposdelivery.db")
public class WebposDeliveryServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebposDeliveryServerApplication.class, args);
  }
}
