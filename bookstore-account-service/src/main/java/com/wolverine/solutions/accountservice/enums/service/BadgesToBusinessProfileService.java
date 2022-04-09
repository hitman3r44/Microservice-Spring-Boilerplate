package com.wolverine.solutions.accountservice.enums.service;

import com.wolverine.solutions.accountservice.enums.dto.BadgesToBusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;

public interface BadgesToBusinessProfileService extends GenericService<BadgesToBusinessProfile, String> {
    BadgesToBusinessProfile asEntity(BadgesToBusinessProfileDTO badgesToBusinessProfileDTO);

    BadgesToBusinessProfileDTO asDTO(BadgesToBusinessProfile save);
}