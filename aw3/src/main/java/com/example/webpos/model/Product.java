package com.example.webpos.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("product")
public class Product {
  @TableId private String id;
  private String name;
  private double price;
  private String image;

  @Override
  public String toString() {
    return getId() + "\t" + getName() + "\t" + getPrice();
  }
}
