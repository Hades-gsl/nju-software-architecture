package com.hades.webpos.webposdelivery.db;

import lombok.Data;

/**
 * @Author: Hades @Date: 2024/6/24 @Description:
 */
@Data
public class Order {
  private String orderId;
  private String status;
}
