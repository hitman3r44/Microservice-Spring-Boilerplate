package com.wolverine.solutions.accountservice.enums.service;

import com.wolverine.solutions.accountservice.enums.dto.ParentCategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.ParentCategory;

public interface ParentCategoryService extends GenericService<ParentCategory, String> {
    ParentCategory asEntity(ParentCategoryDTO parentCategoryDTO);

    ParentCategoryDTO asDTO(ParentCategory save);
}