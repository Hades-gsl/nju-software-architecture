package com.example.webpos.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("category")
public class Category {
  private Integer id;
  private String name;
}
