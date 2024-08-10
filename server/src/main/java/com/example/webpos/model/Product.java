package com.example.webpos.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("product")
public class Product {
  @TableId private Integer id;
  private String name;
  private double price;
  private String img;
  private String category;
  private int stock;
  private int quantity;
}
