package com.wolverine.solutions.accountservice.enums.dto;

import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;

public class BadgesToBusinessProfileDTO extends AbstractDTO<String> {
    private String id;
    private BusinessProfile businessProfile;

    public BadgesToBusinessProfileDTO() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BusinessProfile getBusinessProfile() {
        return this.businessProfile;
    }

    public void setBusinessProfile(BusinessProfile businessProfile) {
        this.businessProfile = businessProfile;
    }
}