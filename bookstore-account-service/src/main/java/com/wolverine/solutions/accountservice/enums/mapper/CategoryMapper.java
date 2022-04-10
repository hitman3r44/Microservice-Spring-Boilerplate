package com.wolverine.solutions.accountservice.enums.mapper;

import com.wolverine.solutions.accountservice.enums.dto.CategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Category asEntity(CategoryDTO dto);
}