package com.wolverine.solutions.accountservice.controller.feature;

import com.github.javafaker.Faker;
import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.dto.UserInformationDTO;
import com.wolverine.solutions.accountservice.enums.entity.UserInformation;
import com.wolverine.solutions.accountservice.service.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.UUID;
import java.util.stream.IntStream;

import static com.wolverine.solutions.accountservice.service.BaseTest.PORT;
import static com.wolverine.solutions.accountservice.service.BaseTest.SERVER_NAME;
import static com.wolverine.solutions.accountservice.service.BaseTest.URI;
import static com.wolverine.solutions.accountservice.service.BaseTest.getRequestHeader;

/**
 * @author Sumit Sarkar
 */
@SpringBootTest
@ExtendWith(BaseTest.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserInformationControllerTest {

    public static final String CONTROLLER_ROUTE = "user-information/";
    private final Faker faker = new Faker();
    private static String lastID;

    @Test
    public void saveTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        IntStream.range(0, 20).forEach(i -> saveFunctionBody(headers));
    }

    private void saveFunctionBody(MultiValueMap<String, String> headers) {
        UserInformationDTO userInformationDTO = new UserInformationDTO();
        userInformationDTO.setId(String.valueOf(UUID.randomUUID()));
        userInformationDTO.setProfilePicture(faker.name().nameWithMiddle());

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE,
                HttpMethod.POST,
                new HttpEntity<>(userInformationDTO, headers),
                UserInformation.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());

        UserInformation userInformation = (UserInformation) entity.getBody();

        lastID = userInformation.getId();
    }

    @Test
    public void findByIdTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        String userInfoId = lastID;

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + userInfoId,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void testList() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void testPageQuery() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + "page-query?page=1&size=20&sort=profilePicture,asc",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void testUpdate() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        String userInfoId = lastID;

        UserInformationDTO userInformationDTO = new UserInformationDTO();
        userInformationDTO.setId(userInfoId);
        userInformationDTO.setProfilePicture("UpdatedWithDate");

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + userInfoId,
                HttpMethod.PUT,
                new HttpEntity<>(userInformationDTO, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        lastID = userInformationDTO.getId();
    }

    @Test
//    @Disabled
    public void testDeleteById() {
        // Change the ID according to DB
        String userInformationId = lastID;
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + userInformationId,
                HttpMethod.DELETE,
                new HttpEntity<>(headers), String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

//    @Test
////    @Disabled
//    public void testRestoreById() {
//        String userInformationId = lastID;
//        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
//
//        ResponseEntity<String> entity = new TestRestTemplate().exchange(
//                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + userInformationId,
//                HttpMethod.PATCH,
//                new HttpEntity<>(headers), String.class);
//        Assert.assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
//    }
}