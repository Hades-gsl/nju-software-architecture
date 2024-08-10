package com.hades.webpos.webposproduct.web;

import com.google.common.annotations.GwtCompatible;
import com.hades.webpos.webposproduct.mapper.ProductMapper;
import com.hades.webpos.webposproduct.model.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource {
  private ProductMapper productMapper;

  @Autowired
  public ProductResource(ProductMapper productMapper) {
    this.productMapper = productMapper;
  }

  @GetMapping("/product")
  public ResponseEntity<List<Product>> getProduct() {
    return new ResponseEntity<>(productMapper.getProducts(), HttpStatus.OK);
  }

  @GetMapping("/product/{asin}")
  public ResponseEntity<Product> getProduct(@PathVariable("asin") String asin) {
    return new ResponseEntity<>(productMapper.getProduct(asin), HttpStatus.OK);
  }
}
