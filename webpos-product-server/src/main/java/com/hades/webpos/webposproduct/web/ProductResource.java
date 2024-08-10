package com.hades.webpos.webposproduct.web;

import com.hades.webpos.webposproduct.mapper.ProductMapper;
import com.hades.webpos.webposproduct.model.Product;
import com.hades.webpos.webposproduct.model.ProductDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class ProductResource {
  //  private ProductMapper productMapper;
  private DatabaseClient databaseClient;

  @Autowired
  public ProductResource(DatabaseClient databaseClient) {
    this.databaseClient = databaseClient;
  }

  @GetMapping("/product")
  public Flux<Product> getProduct() {
    //    List<ProductDao> productDaos = productMapper.getProducts();
    //
    //    List<Product> products = new ArrayList<>();
    //
    //    int i = 0;
    //    for (ProductDao productDao : productDaos) {
    //      products.add(
    //          new Product(
    //              String.valueOf(i++),
    //              productDao.getTitle(),
    //              productDao.getPrice(),
    //              productDao.getImage(),
    //              "drink",
    //              100,
    //              10));
    //    }
    //
    //    return products;
    return databaseClient
        .sql("SELECT * FROM product LIMIT 60")
        .mapProperties(ProductDao.class)
        .all()
        .map(
            productDao ->
                new Product(
                    String.valueOf(new Random().nextInt(1000)),
                    productDao.getTitle(),
                    productDao.getPrice(),
                    productDao.getImage(),
                    "drink",
                    1,
                    10));
  }

  @GetMapping("/product/{id}")
  public Mono<Product> getProductPrice(@PathVariable("id") String id) {
    //    ProductDao productDao = productMapper.getProduct(Integer.parseInt(id));
    //    Product product =
    //        new Product(
    //            id,
    //            productDao.getTitle(),
    //            productDao.getPrice(),
    //            productDao.getImage(),
    //            "drink",
    //            100,
    //            10);
    //    return new ResponseEntity<>(product, HttpStatus.OK);
    return databaseClient
        .sql("SELECT * FROM product LIMIT :id, 1")
        .bind("id", Integer.valueOf(id))
        .mapProperties(ProductDao.class)
        .first()
        .map(
            productDao ->
                new Product(
                    id,
                    productDao.getTitle(),
                    productDao.getPrice(),
                    productDao.getImage(),
                    "drink",
                    1,
                    10));
  }

  @GetMapping("/product/search/{name}")
  public Flux<Product> search(@PathVariable("name") String name) {
    return databaseClient
        .sql("SELECT * FROM product WHERE title LIKE :name")
        .bind("name", "%" + name + "%")
        .mapProperties(ProductDao.class)
        .all()
        .map(
            productDao ->
                new Product(
                    String.valueOf(new Random().nextInt(1000)),
                    productDao.getTitle(),
                    productDao.getPrice(),
                    productDao.getImage(),
                    "drink",
                    1,
                    10));
  }
}
