package com.hades.webpos.webposdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableDiscoveryClient
public class WebposDeliveryServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebposDeliveryServerApplication.class, args);
  }
}
