package com.hades.webpos.webposproduct.model;

import lombok.Data;

/**
 * @Author: Hades @Date: 2024/6/22 @Description:
 */
@Data
public class ProductDao {
  private String mainCategory;
  private String title;
  private float averageRating;
  private int ratingNumber;
  private String description;
  private float price;
  private String image;
  private String parentAsin;
}
