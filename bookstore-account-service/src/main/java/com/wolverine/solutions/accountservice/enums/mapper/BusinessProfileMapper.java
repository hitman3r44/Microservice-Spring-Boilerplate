package com.wolverine.solutions.accountservice.enums.mapper;

import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface BusinessProfileMapper extends GenericMapper<BusinessProfile, BusinessProfileDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    BusinessProfile asEntity(BusinessProfileDTO dto);
}