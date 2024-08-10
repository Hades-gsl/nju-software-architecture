package com.example.webpos.model;

import com.example.webpos.mapper.ItemMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class Cart {

  private List<Item> items;
  private double total = 0;
  private double tax = 0.15;
  private double discount = 0;
  private ItemMapper itemMapper;

  @Autowired
  public Cart(ItemMapper itemMapper) {
    this.itemMapper = itemMapper;
    items = itemMapper.selectList(null);
  }

  public boolean addItem(Product product, int quantity) {
    total += (product.getPrice() * quantity);

    for (Item item : items) {
      if (item.getProduct().getId().equals(product.getId())) {
        item.setQuantity(item.getQuantity() + quantity);
        itemMapper.updateById(item);
        return true;
      }
    }
    return items.add(new Item(product, quantity, product.getId(), "1"));
  }

  public boolean deleteItem(String productId) {
    for (Item item : items) {
      if (item.getProduct().getId().equals(productId)) {
        items.remove(item);
        itemMapper.deleteById(item);
        total -= item.getProduct().getPrice() * item.getQuantity();
        return true;
      }
    }
    return false;
  }

  public boolean minusItem(String productId, int quantity) {
    for (Item item : items) {
      if (item.getProduct().getId().equals(productId)) {
        if (item.getQuantity() > quantity) {
          item.setQuantity(item.getQuantity() - quantity);
          itemMapper.updateById(item);
          total -= item.getProduct().getPrice() * quantity;
          return true;
        } else {
          return deleteItem(productId);
        }
      }
    }
    return false;
  }

  public double checkout() {
    double total = 0;
    for (Item item : items) {
      total += item.getQuantity() * item.getProduct().getPrice();
    }
    items.clear();
    itemMapper.delete(null);
    this.total = 0;
    return total * (1 + tax);
  }

  @Override
  public String toString() {
    if (items.size() == 0) {
      return "Empty Cart";
    }
    double total = 0;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cart -----------------\n");

    for (int i = 0; i < items.size(); i++) {
      stringBuilder.append(items.get(i).toString()).append("\n");
      total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
    }
    stringBuilder.append("----------------------\n");

    stringBuilder.append("Total...\t\t\t" + total);

    return stringBuilder.toString();
  }
}
