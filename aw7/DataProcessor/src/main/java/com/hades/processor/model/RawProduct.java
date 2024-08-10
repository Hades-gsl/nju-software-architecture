package com.hades.processor.model;

import java.awt.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Author: Hades @Date: 2024/5/27 @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawProduct {
    private String mainCategory;
    private String title;
    private float averageRating;
    private int ratingNumber;
    private List<String> description;
    private float price;
    private List<Map<String, String>> images;
    private String parentAsin;
}
