package com.hades.webpos.webposproduct.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Serializable {
  private String id;
  private String name;
  private double price;
  private String img;
  private String category;
  private int stock;
  private int quantity;
}
