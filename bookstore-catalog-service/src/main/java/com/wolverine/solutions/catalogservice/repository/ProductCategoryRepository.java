package com.wolverine.solutions.catalogservice.repository;

import com.wolverine.solutions.catalogservice.repository.dao.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
}
