package com.hades.processor.mapper;

import com.hades.processor.model.Review;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Hades @Date: 2024/5/27 @Description:
 */
@Mapper
public interface ReviewMapper {
  @Insert(
      "INSERT INTO review (id, rating, title, text, asin, parentAsin, userId, timestamp)"
              + "VALUES (#{id}, #{rating}, #{title}, #{text}, #{asin}, #{parentAsin}, #{userId}, #{timestamp})")
  void insertReview(Review review);
}
