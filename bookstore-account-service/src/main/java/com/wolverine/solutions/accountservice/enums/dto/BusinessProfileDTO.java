package com.wolverine.solutions.accountservice.enums.dto;

import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.Category;
import com.wolverine.solutions.accountservice.enums.entity.CertificationtoBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.EmergencysToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.ItemTypeToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.MediaImagesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.PostsToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.ReviewsToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.TagsToBusinessProfile;
import java.util.List;
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
////        "badges"
//})
public class BusinessProfileDTO extends AbstractDTO<String> {
    private String id;
    private String province;
    private String city;
    private String postalCode;
    private String streetName;
    private String streetNumber;
    private String bio;
    private String contactPerson;
    private String email;
    private String employmentSize;
    private String headerImage;
    private String logo;
    private String longDescription;
    private String name;
    private String phone;
    private String photoUrl;
    private String shortDescription;
    private String status;
    private String userId;
    private String website;
    private int followers;
    private int foundationYear;
    private int rating;
    private boolean ispublish;
    private List<TagsToBusinessProfile> tags;
    private List<BadgesToBusinessProfile> badges;
    private List<Category> categoryList;
    private List<CertificationtoBusinessProfile> certification;
    private List<EmergencysToBusinessProfile> emergencyLists;
    private List<ItemTypeToBusinessProfile> itemTypeList;
    private List<PostsToBusinessProfile> postList;
    private List<MediaImagesToBusinessProfile> mediaImageList;
    private List<ReviewsToBusinessProfile> reviewList;
}