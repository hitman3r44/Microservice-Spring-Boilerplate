package com.wolverine.solutions.accountservice.enums.mapper;

import com.wolverine.solutions.accountservice.enums.dto.BadgesToBusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface BadgesToBusinessProfileMapper extends GenericMapper<BadgesToBusinessProfile, BadgesToBusinessProfileDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    BadgesToBusinessProfile asEntity(BadgesToBusinessProfileDTO dto);
}