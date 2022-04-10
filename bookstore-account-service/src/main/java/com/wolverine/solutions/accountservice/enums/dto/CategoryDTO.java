package com.wolverine.solutions.accountservice.enums.dto;

import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.ParentCategory;
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
public class CategoryDTO extends AbstractDTO<String> {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private boolean isfeatured;
    private boolean isforecastingenabled;
    private String status;
    private ParentCategory parentCategoryId;
    private BusinessProfile businessProfile;
}