package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.enums.dto.UserInformationDTO;
import com.wolverine.solutions.accountservice.enums.entity.UserInformation;

public interface UserInformationService extends GenericService<UserInformation, String> {
    UserInformation convertToEntity(UserInformationDTO userInformationDTO);

    UserInformationDTO convertToDto(UserInformation update);

    UserInformation findUserInformationByProfilePicture(String profilePicture);
}