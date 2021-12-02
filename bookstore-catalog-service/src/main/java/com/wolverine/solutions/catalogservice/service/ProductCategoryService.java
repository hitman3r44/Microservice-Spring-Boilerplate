package com.wolverine.solutions.catalogservice.service;

import com.wolverine.solutions.catalogservice.repository.dao.ProductCategory;
import com.wolverine.solutions.catalogservice.web.CreateProductCategoryRequest;
import com.wolverine.solutions.catalogservice.web.UpdateProductCategoryRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Page;

public interface ProductCategoryService {

  String createProductCategory(@Valid CreateProductCategoryRequest createProductCategoryRequest);

  ProductCategory getProductCategory(String productCategoryId);

  void deleteProductCategory(String productCategoryId);

  void updateProductCategory(UpdateProductCategoryRequest updateProductCategoryRequest);

  Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size);
}
