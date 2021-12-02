package com.wolverine.solutions.catalogservice.repository;

import com.wolverine.solutions.catalogservice.repository.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
