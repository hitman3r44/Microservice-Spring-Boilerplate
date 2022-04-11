package com.wolverine.solutions.accountservice.controller.feature;

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
import com.wolverine.solutions.accountservice.service.BaseTest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.IntStream;
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

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BusinessProfileControllerTest extends BaseTest {

  public static final String CONTROLLER_ROUTE = "business-profile/";
  private final static String PAGE_QUERY = "page-query?page=1&size=20&sort=id,asc";
  private static String lastID;
  private final Faker faker = new Faker();
  @Autowired
  BusinessProfileService businessProfileService = new BusinessProfileServiceImpl();
  private static final String jsonDumpFileName = "businessProfile";

  @Test
  public void saveTest() {
    MultiValueMap<String, String> headers = getRequestHeader(
            ConstentVariableTests.APPLICATION_JSON);
    IntStream.range(0, 5).forEach(i -> saveFunctionBody(headers));
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

  @Test
  public void findByIdTest() {
    MultiValueMap<String, String> headers = getRequestHeader(
            ConstentVariableTests.APPLICATION_JSON);
    ResponseEntity<?> entity = new TestRestTemplate().exchange(
            SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + "cbc69e3f-c8a8-4f41-aaa9-55b462742f01",
            HttpMethod.GET,
            new HttpEntity<>(headers),
            BusinessProfile.class);

    objectToJsonMapper((BusinessProfile) entity.getBody(), jsonDumpFileName + "_findByIdTest()");
    Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
  }

  private void objectToJsonMapper(BusinessProfile objectToMapJson, String jsonDumpFileName) {
    ObjectMapper mapper = new ObjectMapper();

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

  @Test
  public void testList() {
    MultiValueMap<String, String> headers = getRequestHeader(
            ConstentVariableTests.APPLICATION_JSON);
    ResponseEntity<?> entity = new TestRestTemplate().exchange(
            SERVER_NAME + PORT + URI + CONTROLLER_ROUTE,
            HttpMethod.GET,
            new HttpEntity<>(headers),
            BusinessProfile.class);

    objectToJsonMapper((BusinessProfile) entity.getBody(), jsonDumpFileName + "_testList()");

    Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
  }

  @Test
  public void testPageQuery() {
    MultiValueMap<String, String> headers = getRequestHeader(
            ConstentVariableTests.APPLICATION_JSON);
    ResponseEntity<?> entity = new TestRestTemplate().exchange(
            SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + PAGE_QUERY,
            HttpMethod.GET,
            new HttpEntity<>(headers),
            String.class);

    Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

    System.out.println(entity.getBody());
  }

  @Test
  public void testUpdate() {
    MultiValueMap<String, String> headers = getRequestHeader(
            ConstentVariableTests.APPLICATION_JSON);

    BusinessProfileDTO businessProfileDTO = generateBusinessProfileDTO();
    businessProfileDTO.setId(lastID);

    ResponseEntity<?> entity = new TestRestTemplate().exchange(
            SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + lastID,
            HttpMethod.PUT,
            new HttpEntity<>(businessProfileDTO, headers),
            String.class);

    Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

    lastID = businessProfileDTO.getId();
  }

  @Test
//    @Disabled
  public void testDeleteById() {
    MultiValueMap<String, String> headers = getRequestHeader(
            ConstentVariableTests.APPLICATION_JSON);
    ResponseEntity<String> entity = new TestRestTemplate().exchange(
            SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + lastID,
            HttpMethod.DELETE,
            new HttpEntity<>(headers), String.class);
    Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
  }

  @Test
//    @Disabled
  public void testRestoreById() {
    MultiValueMap<String, String> headers = getRequestHeader(
            ConstentVariableTests.APPLICATION_JSON);
    ResponseEntity<String> entity = new TestRestTemplate().exchange(
            SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + lastID,
            HttpMethod.PATCH,
            new HttpEntity<>(headers), String.class);
    Assert.assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
  }

  private BusinessProfileDTO generateBusinessProfileDTO() {
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

    BadgesToBusinessProfile badgesToBusinessProfile = getBadgesToBusinessProfile(businessProfileDTO);
    businessProfileDTO.setBadges(Collections.singletonList(badgesToBusinessProfile));

//    Category category = getCategory(businessProfileDTO);
//    businessProfileDTO.setCategoryList(Collections.singletonList(category));
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

  private Category getCategory(BusinessProfileDTO businessProfileDTO) {
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

  private ParentCategory getParentCategory(Category category) {
    ParentCategory parentCategory = new ParentCategory();

    parentCategory.setName(faker.food().ingredient());
    parentCategory.setDescription(faker.superhero().descriptor());
    parentCategory.setStatus(faker.demographic().maritalStatus());
    parentCategory.setImageUrl(faker.internet().image());
    parentCategory.setIsfeatured(faker.bool().bool());
    parentCategory.setId(UUID.randomUUID().toString());
//    parentCategory.setCategoryList(Collections.singletonList(category));

    return parentCategory;
  }

  private BadgesToBusinessProfile getBadgesToBusinessProfile(BusinessProfileDTO businessProfileDTO) {
    BadgesToBusinessProfile badgesToBusinessProfile = new BadgesToBusinessProfile();

    badgesToBusinessProfile.setBusinessProfile(businessProfileService.asEntity(businessProfileDTO));
    badgesToBusinessProfile.setId(String.valueOf(UUID.randomUUID()));
    badgesToBusinessProfile.setBadgeName(faker.buffy().bigBads());
    return badgesToBusinessProfile;
  }
}

