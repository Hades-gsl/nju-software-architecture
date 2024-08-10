package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Settings {
  private Integer id;
  private String app;
  private String store;

  private String addressOne;

  private String addressTwo;

  private String contact;
  private double tax;
  private String symbol;
  private int percentage;
  private String footer;
  private String img;
}
