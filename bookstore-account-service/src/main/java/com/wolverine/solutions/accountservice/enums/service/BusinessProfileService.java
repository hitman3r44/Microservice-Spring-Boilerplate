package com.wolverine.solutions.accountservice.enums.service;

import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;

public interface BusinessProfileService extends GenericService<BusinessProfile, String> {
    BusinessProfile asEntity(BusinessProfileDTO businessProfileDTO);

    BusinessProfileDTO asDTO(BusinessProfile save);

    void restoreById(String id);
}