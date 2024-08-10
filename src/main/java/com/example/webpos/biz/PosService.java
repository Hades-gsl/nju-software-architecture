package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Category;
import com.example.webpos.model.Product;
import com.example.webpos.model.Settings;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Hades @Date: 2024/4/22 19:27 @Description:
 */
@Service
public class PosService {
  private PosDB posDB;

  @Autowired
  public PosService(PosDB posDB) {
    this.posDB = posDB;
  }

  public List<Product> getProducts() {
    return posDB.getProducts();
  }

  public Product getProductById(String id) {
    return posDB.getProduct(id);
  }

  public List<Settings> getSettings() {
    List<Settings> l = new ArrayList<>();
    l.add(
        new Settings(
            1,
            "Standalone Point of Sale",
            "Store-Pos",
            "10086",
            "10087",
            "15968774896",
            0,
            "$",
            10,
            "",
            ""));
    return l;
  }

  public List<Category> getCategories() {
    List<Category> l = new ArrayList<>();
    l.add(new Category(1, "drink"));
    return l;
  }

  public int updateProduct(Product product) {
    return -1;
  }
}
