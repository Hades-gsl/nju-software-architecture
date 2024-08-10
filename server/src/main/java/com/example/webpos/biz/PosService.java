package com.example.webpos.biz;

import com.example.webpos.mapper.CategoryMapper;
import com.example.webpos.mapper.ProductMapper;
import com.example.webpos.mapper.SettingMapper;
import com.example.webpos.model.Category;
import com.example.webpos.model.Product;
import com.example.webpos.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hades @Date: 2024/4/22 19:27 @Description:
 */
@Service
public class PosService {
  private ProductMapper productMapper;
  private SettingMapper settingMapper;
  private CategoryMapper categoryMapper;

  @Autowired
  public PosService(
      ProductMapper productMapper, SettingMapper settingMapper, CategoryMapper categoryMapper) {
    this.productMapper = productMapper;
    this.settingMapper = settingMapper;
    this.categoryMapper = categoryMapper;
  }

  public List<Product> getProducts() {
    return productMapper.selectList(null);
  }

  public Product getProductById(String id) {
    return productMapper.selectById(id);
  }

  public List<Settings> getSettings() {
    return settingMapper.selectList(null);
  }

  public List<Category> getCategories() {
    return categoryMapper.selectList(null);
  }

  public int updateProduct(Product product) {
    return productMapper.updateById(product);
  }
}
