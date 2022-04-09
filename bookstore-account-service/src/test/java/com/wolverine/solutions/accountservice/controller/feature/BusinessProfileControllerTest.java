package com.wolverine.solutions.accountservice.controller.feature;

import com.github.javafaker.Faker;
import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import com.wolverine.solutions.accountservice.enums.service.BusinessProfileService;
import com.wolverine.solutions.accountservice.enums.service.impl.BusinessProfileServiceImpl;
import com.wolverine.solutions.accountservice.service.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
//@ExtendWith(BaseTest.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BusinessProfileControllerTest extends BaseTest {
    public static final String CONTROLLER_ROUTE = "business-profile/";
    private static String lastID;
    private final Faker faker = new Faker();
    @Autowired
    BusinessProfileService businessProfileService = new BusinessProfileServiceImpl();

    @Test
    public void saveTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        IntStream.range(0, 20).forEach(i -> saveFunctionBody(headers));
    }

    private void saveFunctionBody(MultiValueMap<String, String> headers) {
        BusinessProfileDTO businessProfileDTO = generateBusinessProfileDTO();

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE,
                HttpMethod.POST,
                new HttpEntity<>(businessProfileDTO, headers),
                BusinessProfile.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
        BusinessProfile businessProfile = (BusinessProfile) entity.getBody();
        lastID = businessProfile.getId();
    }

    private BusinessProfileDTO generateBusinessProfileDTO() {
        BusinessProfileDTO businessProfileDTO = new BusinessProfileDTO();

        businessProfileDTO.setBio(faker.job().keySkills().toLowerCase());
        businessProfileDTO.setCity(faker.address().cityName());
        businessProfileDTO.setContactPerson(faker.name().username());
        businessProfileDTO.setEmail(faker.internet().emailAddress());
        businessProfileDTO.setEmploymentSize("45");
        businessProfileDTO.setFollowers(faker.number().randomDigit());
        businessProfileDTO.setFoundationYear(faker.number().randomDigit());
        businessProfileDTO.setHeaderImage(faker.internet().image());
        businessProfileDTO.setId(String.valueOf(UUID.randomUUID()));
        businessProfileDTO.setIspublish(true);
        businessProfileDTO.setLogo(faker.company().logo());
        businessProfileDTO.setLongDescription(faker.weather().description());
        businessProfileDTO.setName(faker.name().name());
        businessProfileDTO.setPhone(faker.phoneNumber().cellPhone());
        businessProfileDTO.setPostalCode(faker.address().zipCode());
        businessProfileDTO.setProvince(faker.programmingLanguage().name());
        businessProfileDTO.setRating(1);
        businessProfileDTO.setShortDescription(faker.weather().description());
        businessProfileDTO.setStatus(faker.pokemon().name());
        businessProfileDTO.setStreetName(faker.address().streetName());
        businessProfileDTO.setStreetNumber(faker.address().streetAddressNumber());
        businessProfileDTO.setUserId("42");
        businessProfileDTO.setWebsite(faker.internet().domainName());

        BadgesToBusinessProfile badgesToBusinessProfile = new BadgesToBusinessProfile();
        BusinessProfile businessProfile;
        businessProfile = businessProfileService.asEntity(businessProfileDTO);
//        badgesToBusinessProfile.getBusinessProfile().setId(businessProfileDTO.getId());
        badgesToBusinessProfile.setBusinessProfile(businessProfile);
        badgesToBusinessProfile.setId(String.valueOf(UUID.randomUUID()));
        badgesToBusinessProfile.setBadgeName(faker.buffy().bigBads());
        businessProfileDTO.setBadges(Collections.singletonList(badgesToBusinessProfile));

//        CategorysToBusinessProfile categorysToBusinessProfile = new CategorysToBusinessProfile();
//        categorysToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
//        businessProfileDTO.setCategorieList((List<CategorysToBusinessProfile>) categorysToBusinessProfile);
        businessProfileDTO.setCategorieList(new ArrayList<>());

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
}

