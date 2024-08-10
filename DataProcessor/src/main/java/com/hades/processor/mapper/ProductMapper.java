package com.hades.processor.mapper;

import com.hades.processor.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Hades @Date: 2024/5/27 @Description:
 */
@Mapper
public interface ProductMapper {
  @Insert(
      "INSERT INTO product "
          + "(mainCategory, title, averageRating, ratingNumber, description, price, image, parentAsin) "
          + "VALUES "
          + "(#{mainCategory}, #{title}, #{averageRating}, #{ratingNumber}, #{description}, #{price}, #{image}, #{parentAsin})")
  void insertProduct(Product product);
}
