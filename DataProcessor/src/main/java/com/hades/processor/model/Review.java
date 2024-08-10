package com.hades.processor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Author: Hades @Date: 2024/5/26 @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
  private float rating;
  private String title;
  private String text;
  private String parentAsin;
  private String userId;
  private int timestamp;
}
