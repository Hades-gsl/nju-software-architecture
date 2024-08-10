package com.hades.webpos.webposdelivery.db;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@Component
public class MemDb {
  private Map<String, Long> orders;

  public MemDb() {
    orders = new HashMap<>();
  }

  public void save(String orderId) {
    orders.put(orderId, System.currentTimeMillis());
  }

  public Long get(String orderId) {
    return orders.get(orderId);
  }
}
