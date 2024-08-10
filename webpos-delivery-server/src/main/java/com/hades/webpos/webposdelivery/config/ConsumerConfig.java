package com.hades.webpos.webposdelivery.config;

import com.hades.webpos.webposdelivery.db.MemDb;
import java.util.function.Consumer;

import com.hades.webpos.webposdelivery.db.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@Configuration
public class ConsumerConfig {
  private MemDb memDb;
  private OrderMapper orderMapper;

  @Autowired
  public ConsumerConfig(OrderMapper orderMapper) {
    this.orderMapper = orderMapper;
  }

  @Bean
  public Consumer<String> orderConsumer() {
    return orderId -> {
      System.out.println("Received order: " + orderId);
      orderMapper.insertOrder(orderId, "NEW:" + System.currentTimeMillis());
    };
  }
}
