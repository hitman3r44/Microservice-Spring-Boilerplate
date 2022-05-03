package com.wolverine.solutions.accountservice.controller.feature;

import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.PORT;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.SERVER_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.URI;
import static com.wolverine.solutions.accountservice.service.BaseTest.getRequestHeader;

import com.github.javafaker.Faker;
import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.entity.User;
import com.wolverine.solutions.accountservice.enums.request.CreateUserRequest;
import com.wolverine.solutions.accountservice.enums.response.GetUserInfoResponse;
import com.wolverine.solutions.accountservice.service.BaseTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * @author Sumit Sarkar
 */
@SpringBootTest
@ExtendWith(BaseTest.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {
    @Test
    public void createUserTest() {

        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        CreateUserRequest createUserRequest = new CreateUserRequest();
        Faker faker = new Faker(new Locale("en-US"));

        createUserRequest.setEmail(faker.internet().emailAddress());
        createUserRequest.setFirstName(faker.name().firstName());
        createUserRequest.setLastName(faker.name().lastName());
        createUserRequest.setPassword("iloveyou");
        createUserRequest.setRoleNames(new ArrayList<>(Arrays.asList("STANDARD_USER", "ADMIN_USER")));
        createUserRequest.setUserId(String.valueOf(UUID.randomUUID()));
        createUserRequest.setUserName(faker.name().username());

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user",
                HttpMethod.POST,
                new HttpEntity<>(createUserRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

    @Test
    public void getUserInfoTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<GetUserInfoResponse> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "userInfo",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                GetUserInfoResponse.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void getUserByNameAndIdTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user?userName=admin.admin&userId=xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void getUserByNameTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user?userName=admin.admin",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void getUserByIdTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user?userId=xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void getUserNoParamsTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void getAllUsersTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "users",
                HttpMethod.GET,
                new HttpEntity<>(headers), String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    @Disabled
    public void updateUserTest() {
        String userId = ConstentVariableTests.TEST_USER_ID;
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        User updateUserRequest = new User();
        Faker faker = new Faker(new Locale("en-US"));

        updateUserRequest.setEmail(ConstentVariableTests.TEST_USER_EMAIL);
        updateUserRequest.setFirstName(faker.name().firstName());
        updateUserRequest.setLastName(faker.name().lastName());
        updateUserRequest.setPassword("iloveyou");

        updateUserRequest.setUserId(String.valueOf(UUID.randomUUID()));
        updateUserRequest.setUserName(ConstentVariableTests.TEST_USER_NAME);

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user/" + userId,
                HttpMethod.PUT,
                new HttpEntity<>(updateUserRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    @Disabled
    public void updateUserInfoTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        User updateUserRequest = new User();
        Faker faker = new Faker(new Locale("en-US"));

        updateUserRequest.setEmail(ConstentVariableTests.TEST_USER_EMAIL);
        updateUserRequest.setFirstName(faker.name().firstName());
        updateUserRequest.setLastName(faker.name().lastName());
        updateUserRequest.setPassword("iloveyou");
        updateUserRequest.setUserId(ConstentVariableTests.TEST_USER_ID);
        updateUserRequest.setUserName(ConstentVariableTests.TEST_USER_NAME);

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "userInfo",
                HttpMethod.PUT,
                new HttpEntity<>(updateUserRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void deleteUserByIdTest() {
        String userId = ConstentVariableTests.TEST_USER_ID;
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user/" + userId,
                HttpMethod.DELETE,
                new HttpEntity<>(headers), String.class);
        Assert.assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
    }

    @Test
    public void restoreUserByIdTest() {
        String userId = ConstentVariableTests.TEST_USER_ID;
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user/" + userId,
                HttpMethod.PATCH,
                new HttpEntity<>(headers), String.class);
        Assert.assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
    }
}
