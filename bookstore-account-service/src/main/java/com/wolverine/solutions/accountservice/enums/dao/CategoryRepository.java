package com.wolverine.solutions.accountservice.enums.dao;

import com.wolverine.solutions.accountservice.enums.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}