package com.wolverine.solutions.accountservice.enums.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonIgnoreProperties({
//        "hibernateLazyInitializer",
//        "handler",
//        "businessProfile"
//})
public class BadgesToBusinessProfileDTO extends AbstractDTO<String> {
    private String id;
    private String badgeName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BusinessProfile businessProfile;
}