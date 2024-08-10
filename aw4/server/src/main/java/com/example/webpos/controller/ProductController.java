package com.example.webpos.controller;

import com.example.webpos.api.ProductApi;
import com.example.webpos.biz.PosService;
import com.example.webpos.dto.ProductDto;
import com.example.webpos.dto.ProductGet200ResponseInnerDto;
import com.example.webpos.dto.ProductPidGet200ResponseDto;
import com.example.webpos.dto.ProductPidPatchRequestDto;
import com.example.webpos.model.Product;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hades @Date: 2024/4/22 19:05 @Description:
 */
@RestController
@CrossOrigin
public class ProductController implements ProductApi {
  private PosService posService;

  @Autowired
  public ProductController(PosService posService) {
    this.posService = posService;
  }

  @Override
  public ResponseEntity<List<ProductGet200ResponseInnerDto>> productGet() {
    List<Product> products = posService.getProducts();

    List<ProductGet200ResponseInnerDto> res = new ArrayList<>();
    for (Product product : products) {
      res.add(
          new ProductGet200ResponseInnerDto()
              .id(String.valueOf(product.getId()))
              .name(product.getName())
              .price(BigDecimal.valueOf(product.getPrice()))
              .img(product.getImg())
              .category(product.getCategory())
              .quantity(product.getQuantity())
              .stock(product.getStock()));
    }

    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ProductPidGet200ResponseDto> productPidGet(
      @Parameter(name = "pid", description = "", required = true, in = ParameterIn.PATH)
          @PathVariable("pid")
          String pid) {
    Product product = posService.getProductById(pid);

    if (product == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    ProductPidGet200ResponseDto res =
        new ProductPidGet200ResponseDto()
            .id(String.valueOf(product.getId()))
            .name(product.getName())
            .price(BigDecimal.valueOf(product.getPrice()))
            .img(product.getImg())
            .category(product.getCategory())
            .quantity(product.getQuantity())
            .stock(product.getStock());

    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ProductDto> productPidPatch(
      @Parameter(name = "pid", description = "", required = true, in = ParameterIn.PATH)
          @PathVariable("pid")
          String pid,
      @Parameter(name = "ProductPidPatchRequestDto", description = "")
          @Valid
          @RequestBody(required = false)
          ProductPidPatchRequestDto productPidPatchRequestDto) {
    Product product = posService.getProductById(pid);

    if (product == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    product.setQuantity(productPidPatchRequestDto.getQuantity());
    posService.updateProduct(product);

    ProductDto res =
        new ProductDto()
            .id(String.valueOf(product.getId()))
            .name(product.getName())
            .price(BigDecimal.valueOf(product.getPrice()))
            .img(product.getImg())
            .category(product.getCategory())
            .quantity(product.getQuantity())
            .stock(product.getStock());

    return new ResponseEntity<>(res, HttpStatus.OK);
  }
}
