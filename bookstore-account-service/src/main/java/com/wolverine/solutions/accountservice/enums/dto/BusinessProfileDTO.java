package com.wolverine.solutions.accountservice.enums.dto;

import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.CategorysToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.CertificationtoBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.EmergencysToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.ItemTypeToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.MediaImagesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.PostsToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.ReviewsToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.TagsToBusinessProfile;

import java.util.List;

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
    private List<CategorysToBusinessProfile> categorieList;
    private List<CertificationtoBusinessProfile> certification;
    private List<EmergencysToBusinessProfile> emergencyLists;
    private List<ItemTypeToBusinessProfile> itemTypeList;
    private List<PostsToBusinessProfile> postList;
    private List<MediaImagesToBusinessProfile> mediaImageList;
    private List<ReviewsToBusinessProfile> reviewList;

    public BusinessProfileDTO() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmploymentSize() {
        return this.employmentSize;
    }

    public void setEmploymentSize(String employmentSize) {
        this.employmentSize = employmentSize;
    }

    public String getHeaderImage() {
        return this.headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getFollowers() {
        return this.followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFoundationYear() {
        return this.foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean getIspublish() {
        return this.ispublish;
    }

    public void setIspublish(boolean ispublish) {
        this.ispublish = ispublish;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.TagsToBusinessProfile> getTags() {
        return this.tags;
    }

    public void setTags(java.util.List<com.wolverine.solutions.accountservice.enums.entity.TagsToBusinessProfile> tags) {
        this.tags = tags;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile> getBadges() {
        return this.badges;
    }

    public void setBadges(java.util.List<com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile> badges) {
        this.badges = badges;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.CategorysToBusinessProfile> getCategorieList() {
        return this.categorieList;
    }

    public void setCategorieList(java.util.List<com.wolverine.solutions.accountservice.enums.entity.CategorysToBusinessProfile> categorieList) {
        this.categorieList = categorieList;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.CertificationtoBusinessProfile> getCertification() {
        return this.certification;
    }

    public void setCertification(java.util.List<com.wolverine.solutions.accountservice.enums.entity.CertificationtoBusinessProfile> certification) {
        this.certification = certification;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.EmergencysToBusinessProfile> getEmergencyLists() {
        return this.emergencyLists;
    }

    public void setEmergencyLists(java.util.List<com.wolverine.solutions.accountservice.enums.entity.EmergencysToBusinessProfile> emergencyLists) {
        this.emergencyLists = emergencyLists;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.ItemTypeToBusinessProfile> getItemTypeList() {
        return this.itemTypeList;
    }

    public void setItemTypeList(java.util.List<com.wolverine.solutions.accountservice.enums.entity.ItemTypeToBusinessProfile> itemTypeList) {
        this.itemTypeList = itemTypeList;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.PostsToBusinessProfile> getPostList() {
        return this.postList;
    }

    public void setPostList(java.util.List<com.wolverine.solutions.accountservice.enums.entity.PostsToBusinessProfile> postList) {
        this.postList = postList;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.MediaImagesToBusinessProfile> getMediaImageList() {
        return this.mediaImageList;
    }

    public void setMediaImageList(java.util.List<com.wolverine.solutions.accountservice.enums.entity.MediaImagesToBusinessProfile> mediaImageList) {
        this.mediaImageList = mediaImageList;
    }

    public java.util.List<com.wolverine.solutions.accountservice.enums.entity.ReviewsToBusinessProfile> getReviewList() {
        return this.reviewList;
    }

    public void setReviewList(java.util.List<com.wolverine.solutions.accountservice.enums.entity.ReviewsToBusinessProfile> reviewList) {
        this.reviewList = reviewList;
    }
}