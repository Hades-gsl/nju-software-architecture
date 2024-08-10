package com.hades.webpos.webposorder.model;

import lombok.Data;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@Data
public class OrderDto {
  private String[] productId;
  private int[] count;
}
