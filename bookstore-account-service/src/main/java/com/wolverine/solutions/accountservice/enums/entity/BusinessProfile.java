package com.wolverine.solutions.accountservice.enums.entity;

import com.wolverine.solutions.commons.util.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumit Sarkar
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business_profile")
@Builder
@SQLDelete(sql = "UPDATE business_profile SET is_deleted = true WHERE id=?")
//@Where(clause = "is_deleted = false")
@FilterDef(
        name = "deletedUserFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedUserFilter",
        condition = "is_deleted = :isDeleted"
)
public class BusinessProfile extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "bio")
    private String bio;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "email")
    private String email;
    @Column(name = "employment_size")
    private String employmentSize;
    @Column(name = "header_image")
    private String headerImage;
    @Column(name = "logo")
    private String logo;
    @Column(name = "long_description")
    private String longDescription;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "status")
    private String status;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "website")
    private String website;

    @Column(name = "followers")
    private int followers;
    @Column(name = "foundation_year")
    private int foundationYear;
    @Column(name = "rating")
    private int rating;

    @Column(name = "isPublish")
    private boolean ispublish;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "businessProfile", targetEntity = BadgesToBusinessProfile.class)
    private List<BadgesToBusinessProfile> badges = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<TagsToBusinessProfile> tags = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<CategorysToBusinessProfile> categorieList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<CertificationtoBusinessProfile> certification = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<EmergencysToBusinessProfile> emergencyLists = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<ItemTypeToBusinessProfile> itemTypeList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<PostsToBusinessProfile> postList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<MediaImagesToBusinessProfile> mediaImageList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    private List<ReviewsToBusinessProfile> reviewList = new ArrayList<>();
}