package com.wolverine.solutions.accountservice.enums.mapper;

import com.wolverine.solutions.accountservice.enums.dto.ParentCategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.ParentCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ParentCategoryMapper extends GenericMapper<ParentCategory, ParentCategoryDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    ParentCategory asEntity(ParentCategoryDTO dto);
}