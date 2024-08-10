package com.example.webpos.db;

import com.example.webpos.mapper.ProductMapper;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PosMysqlDB implements PosDB {
  private List<Product> products;

  private Cart cart;
  private ProductMapper productMapper;

  @Autowired
  public PosMysqlDB(Cart cart, ProductMapper productMapper) {
    this.productMapper = productMapper;
    this.cart = cart;
    this.products = productMapper.selectList(null);
  }

  @Override
  public List<Product> getProducts() {
    return products;
  }

  @Override
  public Cart saveCart(Cart cart) {
    this.cart = cart;
    return this.cart;
  }

  @Override
  public Cart getCart() {
    return this.cart;
  }

  @Override
  public Product getProduct(String productId) {
    for (Product p : getProducts()) {
      if (p.getId().equals(productId)) {
        return p;
      }
    }
    return null;
  }
}
