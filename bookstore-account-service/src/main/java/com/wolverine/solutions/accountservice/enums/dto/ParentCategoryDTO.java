package com.wolverine.solutions.accountservice.enums.dto;

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
public class ParentCategoryDTO extends AbstractDTO<String> {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private boolean isfeatured;
    private boolean isforecastingenabled;
    private String status;
}