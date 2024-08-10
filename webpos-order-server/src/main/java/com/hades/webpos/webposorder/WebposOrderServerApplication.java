package com.hades.webpos.webposorder;

import com.hades.webpos.webposorder.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

@SpringBootApplication
@EnableDiscoveryClient
public class WebposOrderServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebposOrderServerApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
