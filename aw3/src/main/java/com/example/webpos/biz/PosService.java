package com.example.webpos.biz;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

import java.util.List;

public interface PosService {
    public Cart getCart();

    public Cart newCart();

    public double checkout(Cart cart);

    public void total(Cart cart);

    public boolean add(Product product, int amount);

    public boolean add(String productId, int amount);
    public boolean minus(String productId, int amount);
    public boolean delete(String productId);

    public List<Product> products();
}
