package com.hades.webpos.webposreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebposReviewServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebposReviewServerApplication.class, args);
  }
}
