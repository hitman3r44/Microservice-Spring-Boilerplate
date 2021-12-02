package com.wolverine.solutions.catalogservice.service;

import com.wolverine.solutions.catalogservice.repository.dao.Product;
import com.wolverine.solutions.catalogservice.web.CreateProductRequest;
import com.wolverine.solutions.catalogservice.web.ProductResponse;
import com.wolverine.solutions.catalogservice.web.UpdateProductRequest;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

  String createProduct(@Valid CreateProductRequest createProductRequest);

  ProductResponse getProduct(String productId);

  void deleteProduct(String productId);

  void updateProduct(UpdateProductRequest updateProductRequest);

  Page<Product> findAllProducts(Pageable pageable);

  Page<ProductResponse> getAllProducts(String sort, Integer page, Integer size);
}
