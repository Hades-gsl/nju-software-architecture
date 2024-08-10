package com.example.webpos.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("item")
public class Item {
  @TableField(exist = false)
  private Product product;

  private int quantity;

  @TableField("product_id")
  private String productId;

  @TableId private String id;

  @Override
  public String toString() {
    return product.toString() + "\t" + quantity;
  }
}
