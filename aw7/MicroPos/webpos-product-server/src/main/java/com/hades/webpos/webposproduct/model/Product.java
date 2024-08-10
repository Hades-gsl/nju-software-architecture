package com.hades.webpos.webposproduct.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Product {
  private String mainCategory;
  private String title;
  private float averageRating;
  private int ratingNumber;
  private String description;
  private float price;
  private String image;
  private String parentAsin;
}
