package com.wolverine.solutions.accountservice.enums.service;

import com.wolverine.solutions.accountservice.enums.dto.CategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.Category;

public interface CategoryService extends GenericService<Category, String> {
    Category asEntity(CategoryDTO categoryDTO);

    CategoryDTO asDTO(Category save);
}