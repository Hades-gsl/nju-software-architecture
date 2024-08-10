package com.hades.webpos.webposproduct.mapper;

import com.hades.webpos.webposproduct.model.Product;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Hades @Date: 2024/5/27 @Description:
 */
@Mapper
public interface ProductMapper {
    List<Product> getProducts();
    Product getProduct(String asin);
}
