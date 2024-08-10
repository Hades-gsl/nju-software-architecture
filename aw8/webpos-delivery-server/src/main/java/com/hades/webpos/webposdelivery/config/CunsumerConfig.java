package com.hades.webpos.webposdelivery.config;

import com.hades.webpos.webposdelivery.db.MemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@Configuration
public class CunsumerConfig {
  private MemDb memDb;

  @Autowired
  public CunsumerConfig(MemDb memDb) {
    this.memDb = memDb;
  }

  @Bean
  public Consumer<String> orderConsumer() {
    return orderId -> {
      System.out.println("Received order: " + orderId);
      memDb.save(orderId);
    };
  }
}
