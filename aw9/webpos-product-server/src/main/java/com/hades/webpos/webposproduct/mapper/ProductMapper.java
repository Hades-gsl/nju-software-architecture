package com.hades.webpos.webposproduct.mapper;

import com.hades.webpos.webposproduct.model.ProductDao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Hades @Date: 2024/6/22 @Description:
 */
@Mapper
public interface ProductMapper {
  @Select("SELECT * FROM product LIMIT 60")
  List<ProductDao> getProducts();

  @Select("SELECT * FROM product LIMIT #{id}, 1")
  ProductDao getProduct(int id);
}
