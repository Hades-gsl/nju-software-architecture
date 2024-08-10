package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PosServiceImp implements PosService {

  private PosDB posDB;

  @Autowired
  public void setPosDB(PosDB posDB) {
    this.posDB = posDB;
  }

  @Override
  public Cart getCart() {

    Cart cart = posDB.getCart();
    if (cart == null) {
      cart = this.newCart();
    }
    return cart;
  }

  @Override
  public Cart newCart() {
    posDB.getCart().checkout();
    return posDB.getCart();
  }

  @Override
  public double checkout(Cart cart) {
    return cart.checkout();
  }

  @Override
  public void total(Cart cart) {}

  @Override
  public boolean add(Product product, int amount) {
    return false;
  }

  @Override
  public boolean add(String productId, int amount) {

    Product product = posDB.getProduct(productId);
    if (product == null) {
      return false;
    }

    this.getCart().addItem(product, amount);
    return true;
  }

  @Override
  public List<Product> products() {
    return posDB.getProducts();
  }

  @Override
  public boolean delete(String productId) {
    return this.getCart().deleteItem(productId);
  }

  @Override
  public boolean minus(String productId, int amount) {
    return this.getCart().minusItem(productId, amount);
  }
}
