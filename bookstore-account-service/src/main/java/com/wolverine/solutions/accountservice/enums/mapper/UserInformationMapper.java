package com.wolverine.solutions.accountservice.enums.mapper;

import com.wolverine.solutions.accountservice.enums.dto.UserInformationDTO;
import com.wolverine.solutions.accountservice.enums.entity.UserInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UserInformationMapper extends GenericMapper<UserInformation, UserInformationDTO> {
    @Override
    @Mapping(target = "id")
    UserInformation asEntity(UserInformationDTO dto);
}