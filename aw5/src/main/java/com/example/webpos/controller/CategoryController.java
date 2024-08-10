package com.example.webpos.controller;

import com.example.webpos.api.CategoriesApi;
import com.example.webpos.biz.PosService;
import com.example.webpos.dto.CategoriesGet200ResponseInnerDto;
import com.example.webpos.dto.CategoryDto;
import com.example.webpos.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hades @Date: 2024/4/22 19:17 @Description:
 */
@RestController
@CrossOrigin
public class CategoryController implements CategoriesApi {
  private PosService posService;

  @Autowired
  public CategoryController(PosService posService) {
    this.posService = posService;
  }

  @Override
  public ResponseEntity<List<CategoriesGet200ResponseInnerDto>> categoriesGet() {
    List<Category> categories = posService.getCategories();

    List<CategoriesGet200ResponseInnerDto> res = new ArrayList<>();
    for (Category category : categories) {
      res.add(
          new CategoriesGet200ResponseInnerDto()
              .id(String.valueOf(category.getId()))
              .name(category.getName()));
    }

    return new ResponseEntity<>(res, HttpStatus.OK);
  }
}
