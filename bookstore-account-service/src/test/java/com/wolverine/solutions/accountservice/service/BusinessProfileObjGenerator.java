package com.wolverine.solutions.accountservice.service;

import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.PORT;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.SERVER_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.URI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.Category;
import com.wolverine.solutions.accountservice.enums.entity.ParentCategory;
import com.wolverine.solutions.accountservice.enums.service.BusinessProfileService;
import com.wolverine.solutions.accountservice.enums.service.impl.BusinessProfileServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * @author Sumit Sarkar
 */
public class BusinessProfileObjGenerator {

    private static final Faker faker = new Faker();
    private static final BusinessProfileService businessProfileService = new BusinessProfileServiceImpl();

    public static void saveFunctionBody(MultiValueMap<String, String> headers) {
        BusinessProfileDTO businessProfileDTO = BusinessProfileObjGenerator.generateBusinessProfileDTO();
        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + ConstentVariableTests.CONTROLLER_ROUTE,
                HttpMethod.POST,
                new HttpEntity<>(businessProfileDTO, headers),
                BusinessProfile.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
        BusinessProfile businessProfile = (BusinessProfile) entity.getBody();
        assert businessProfile != null;
        ConstentVariableTests.lastID = businessProfile.getId();
    }

    public static void objectToJsonMapper(BusinessProfile objectToMapJson, String jsonDumpFileName) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        File file = new File(jsonDumpFileName + ".json");
        try {
            // Serialize Java object info JSON file.
            mapper.writeValue(file, objectToMapJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

//    try {
//      // Deserialize JSON file into Java object.
//      Objects objects = mapper.readValue(file, Objects.class);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    }

    public static BusinessProfileDTO generateBusinessProfileDTO() {
        BusinessProfileDTO businessProfileDTO = new BusinessProfileDTO();

        businessProfileDTO.setBio(faker.job().keySkills().toLowerCase());
        businessProfileDTO.setCity(faker.address().cityName());
        businessProfileDTO.setContactPerson(faker.name().username());
        businessProfileDTO.setEmail(faker.internet().emailAddress());
        businessProfileDTO.setEmploymentSize(String.valueOf(faker.number().numberBetween(100, 1000)));
        businessProfileDTO.setFollowers(faker.number().randomDigit());
        businessProfileDTO.setFoundationYear(faker.number().randomDigit());
        businessProfileDTO.setHeaderImage(faker.internet().image());
        businessProfileDTO.setId(String.valueOf(UUID.randomUUID()));
        businessProfileDTO.setIspublish(faker.bool().bool());
        businessProfileDTO.setLogo(faker.company().logo());
        businessProfileDTO.setLongDescription(faker.weather().description());
        businessProfileDTO.setName(faker.name().name());
        businessProfileDTO.setPhone(faker.phoneNumber().cellPhone());
        businessProfileDTO.setPostalCode(faker.address().zipCode());
        businessProfileDTO.setProvince(faker.programmingLanguage().name());
        businessProfileDTO.setRating(faker.number().numberBetween(0, 10));
        businessProfileDTO.setShortDescription(faker.weather().description());
        businessProfileDTO.setStatus(faker.pokemon().name());
        businessProfileDTO.setStreetName(faker.address().streetName());
        businessProfileDTO.setStreetNumber(faker.address().streetAddressNumber());
        businessProfileDTO.setUserId(String.valueOf(UUID.randomUUID()));
        businessProfileDTO.setWebsite(faker.internet().domainName());

        BadgesToBusinessProfile badgesToBusinessProfile = BusinessProfileObjGenerator.getBadgesToBusinessProfile(businessProfileDTO);
        businessProfileDTO.setBadges(Collections.singletonList(badgesToBusinessProfile));

//        Category category = getCategory(businessProfileDTO);
//        businessProfileDTO.setCategoryList(Collections.singletonList(category));
        businessProfileDTO.setCategoryList(new ArrayList<>());

//        CertificationtoBusinessProfile certificationtoBusinessProfile = new CertificationtoBusinessProfile();
//        certificationtoBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setCertification((List<CertificationtoBusinessProfile>) certificationtoBusinessProfile);
        businessProfileDTO.setCertification(new ArrayList<>());

//        EmergencysToBusinessProfile emergencysToBusinessProfile = new EmergencysToBusinessProfile();
//        emergencysToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setEmergencyLists((List<EmergencysToBusinessProfile>) emergencysToBusinessProfile);
        businessProfileDTO.setEmergencyLists(new ArrayList<>());

//        ItemTypeToBusinessProfile itemTypeToBusinessProfile = new ItemTypeToBusinessProfile();
//        itemTypeToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setItemTypeList((List<ItemTypeToBusinessProfile>) itemTypeToBusinessProfile);

        businessProfileDTO.setItemTypeList(new ArrayList<>());

//        MediaImagesToBusinessProfile mediaImagesToBusinessProfile = new MediaImagesToBusinessProfile();
//        mediaImagesToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setMediaImageList((List<MediaImagesToBusinessProfile>) mediaImagesToBusinessProfile);
        businessProfileDTO.setMediaImageList(new ArrayList<>());

//        PostsToBusinessProfile postsToBusinessProfile = new PostsToBusinessProfile();
//        postsToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setPostList((List<PostsToBusinessProfile>) postsToBusinessProfile);
        businessProfileDTO.setPostList(new ArrayList<>());

//        ReviewsToBusinessProfile reviewsToBusinessProfile = new ReviewsToBusinessProfile();
//        reviewsToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setReviewList((List<ReviewsToBusinessProfile>) reviewsToBusinessProfile);
        businessProfileDTO.setReviewList(new ArrayList<>());

//        TagsToBusinessProfile tagsToBusinessProfile = new TagsToBusinessProfile();
//        tagsToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setTags((List<TagsToBusinessProfile>) tagsToBusinessProfile);
        businessProfileDTO.setTags(new ArrayList<>());

        return businessProfileDTO;
    }

    private static BadgesToBusinessProfile getBadgesToBusinessProfile(BusinessProfileDTO businessProfileDTO) {
        BadgesToBusinessProfile badgesToBusinessProfile = new BadgesToBusinessProfile();

        badgesToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
        badgesToBusinessProfile.setId(String.valueOf(UUID.randomUUID()));
        badgesToBusinessProfile.setBadgeName(faker.buffy().bigBads());
        return badgesToBusinessProfile;
    }

    private static Category getCategory(BusinessProfileDTO businessProfileDTO) {
        Category category = new Category();

        category.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
        category.setName(faker.book().genre());
        category.setDescription(faker.superhero().descriptor());
        category.setStatus(faker.demographic().maritalStatus());
        category.setImageUrl(faker.internet().image());
        category.setIsfeatured(faker.bool().bool());
        category.setId(UUID.randomUUID().toString());

        ParentCategory parentCategory = getParentCategory(category);
        category.setParentCategory(parentCategory);

        return category;
    }

    private static ParentCategory getParentCategory(Category category) {
        ParentCategory parentCategory = new ParentCategory();

        parentCategory.setName(faker.food().ingredient());
        parentCategory.setDescription(faker.superhero().descriptor());
        parentCategory.setStatus(faker.demographic().maritalStatus());
        parentCategory.setImageUrl(faker.internet().image());
        parentCategory.setIsfeatured(faker.bool().bool());
        parentCategory.setId(UUID.randomUUID().toString());
        parentCategory.setCategoryList(Collections.singletonList(category));

        return parentCategory;
    }
}
