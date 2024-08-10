package com.example.webpos.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("settings")
public class Settings {
  @TableId private Integer id;
  private String app;
  private String store;

  @TableField("address_one")
  private String addressOne;

  @TableField("address_two")
  private String addressTwo;

  private String contact;
  private double tax;
  private String symbol;
  private int percentage;
  private String footer;
  private String img;
}
