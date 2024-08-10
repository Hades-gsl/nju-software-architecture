package com.hades.webpos.webposreview.model;

import lombok.Data;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@Data
public class Review {
  private float rating;
  private String title;
  private String text;
  private String parentAsin;
  private String userId;
  private int timestamp;
}
