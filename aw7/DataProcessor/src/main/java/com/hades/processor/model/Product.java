package com.hades.processor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Author: Hades @Date: 2024/5/26 @Description:
 */
@Data
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
