package com.hades.webpos.webposreview.web;

import com.hades.webpos.webposreview.mapper.ReviewMapper;
import com.hades.webpos.webposreview.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@RestController
public class ReviewResource {
  private ReviewMapper reviewMapper;

  @Autowired
  public ReviewResource(ReviewMapper reviewMapper) {
    this.reviewMapper = reviewMapper;
  }

  @GetMapping("/reviews/{asin}")
  public ResponseEntity<List<Review>> getReviews(@PathVariable("asin") String asin) {
    return new ResponseEntity<>(reviewMapper.getReviews(asin), HttpStatus.OK);
  }
}
