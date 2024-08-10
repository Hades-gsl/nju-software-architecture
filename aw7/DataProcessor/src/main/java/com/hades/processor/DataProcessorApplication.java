package com.hades.processor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hades.processor.mapper")
public class DataProcessorApplication {

  public static void main(String[] args) {
    SpringApplication.run(DataProcessorApplication.class, args);
  }
}
