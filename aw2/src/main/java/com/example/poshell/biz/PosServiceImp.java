package com.example.poshell.biz;

import com.example.poshell.db.PosDB;
import com.example.poshell.model.Cart;
import com.example.poshell.model.Item;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PosServiceImp implements PosService {

  private PosDB posDB;

  @Autowired
  public void setPosDB(PosDB posDB) {
    this.posDB = posDB;
  }

  @Override
  public Cart getCart() {
    return posDB.getCart();
  }

  @Override
  public Cart newCart() {
    return posDB.saveCart(new Cart());
  }

  @Override
  public void checkout(Cart cart) {
    total(cart);
    newCart();
  }

  @Override
  public void total(Cart cart) {
    double sum = 0;
    for (Item item : cart.getItems()) {
      sum += item.getProduct().getPrice() * item.getAmount();
    }
    System.out.println("Total: " + sum);
  }

  @Override
  public boolean add(Product product, int amount) {
    return false;
  }

  @Override
  public boolean add(String productId, int amount) {
    if (amount <= 0 || posDB.getCart() == null) return false;

    Product product = posDB.getProduct(productId);
    if (product == null) return false;

    this.getCart().addItem(new Item(product, amount));
    return true;
  }

  @Override
  public boolean reduce(String productId, int amount) {
    if (amount <= 0 || posDB.getCart() == null) return false;

    Product product = posDB.getProduct(productId);
    if (product == null) return false;

    Cart cart = this.getCart();
    for (Item item : cart.getItems()) {
      if (item.getProduct().getId().equals(productId)) {
        if (item.getAmount() > amount) {
          item.setAmount(item.getAmount() - amount);
        } else {
          cart.getItems().remove(item);
        }
        return true;
      }
    }

    return false;
  }

  @Override
  public List<Product> products() {
    return posDB.getProducts();
  }
}
