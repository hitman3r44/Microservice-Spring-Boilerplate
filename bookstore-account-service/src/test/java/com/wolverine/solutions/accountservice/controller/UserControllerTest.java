package com.wolverine.solutions.accountservice.controller;

import com.github.javafaker.Faker;
import com.wolverine.solutions.accountservice.repository.dao.User;
import com.wolverine.solutions.accountservice.web.CreateUserRequest;
import com.wolverine.solutions.accountservice.web.GetUserInfoResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author Sumit Sarkar
 */
@SpringBootTest
public class UserControllerTest {
    public static final String TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsid2ViIl0sInVzZXJfaWQiOiJ4Y3ZjdmJ2di1iYTVkLTRiOTItODViZS1kZmdkZmdkZmdkZmciLCJ1c2VyX25hbWUiOiJhZG1pbi5hZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE2NDYzMTQyNjQsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6InZZbU1Sc19aMXhEazFLNFV1WmtVUGxtMGpJMCIsImNsaWVudF9pZCI6IjkzZWQ0NTNlLWI3YWMtNDE5Mi1hNmQ0LWM0NWZhZTBkOTlhYyJ9.CCEDqsBtEn5e1yciDHWHbV_z8oyFb65mV5vhBQZ1CSm3uSIwoakwcM48-i3NY9E5V2R8iiD7nELrORl-MrX3E89B3NmCbFgACA11bPYRrZM5dQwfICbjVjFZMNv9_iZS07Xs9yOpCplGBMs9rx1lMd_s-buLP4utPc-_OmvlBLgm4pNPNQAV5Q3qaGGetuRoPk1ulefN9iLBF_Sxb7-NcsdzFeh0zO3mNWTZt5XPcuaRMmQ6bplL35yt7Kurd2VuTZv72hyDZCiOgIN3xkdGDUc2P5PQMIZ-yIwomsv90mLNbSDVxP-q3Lw3qxwTGhRDBsLH1gnnnR74uUbqRQeBXA";
    public static final String SERVER_NAME = "http://localhost:";
    public static final String PORT = "8765";
    public static final String URI = "/api/account/";

    @Test
    public void createUserTest() {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

        CreateUserRequest createUserRequest = new CreateUserRequest();
        Faker faker = new Faker(new Locale("en-US"));

        createUserRequest.setEmail(faker.internet().emailAddress());
        createUserRequest.setFirstName(faker.name().firstName());
        createUserRequest.setLastName(faker.name().lastName());
        createUserRequest.setPassword("iloveyou");
        createUserRequest.setRoleNames(new ArrayList<>(Arrays.asList("STANDARD_USER", "ADMIN_USER")));
        createUserRequest.setUserId(String.valueOf(faker.number().numberBetween(20, 70)));
        createUserRequest.setUserName(faker.name().username());

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user",
                HttpMethod.POST,
                new HttpEntity<>(createUserRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

    @Test
    public void updateUserTest() {

        String userId = "dfgdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

        User updateUserRequest = new User();
        Faker faker = new Faker(new Locale("en-US"));

        updateUserRequest.setEmail(faker.internet().emailAddress());
        updateUserRequest.setFirstName(faker.name().firstName());
        updateUserRequest.setLastName(faker.name().lastName());
        updateUserRequest.setPassword("iloveyou");

        updateUserRequest.setUserId(String.valueOf(faker.number().numberBetween(20, 70)));
        updateUserRequest.setUserName(faker.name().username());

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user/" + userId,
                HttpMethod.PUT,
                new HttpEntity<>(updateUserRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void updateUserInfoTest() {

        String userName = "5f9135fc-a22a-4666-bd29-aed229673496";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

        User updateUserRequest = new User();
        Faker faker = new Faker(new Locale("en-US"));

        updateUserRequest.setEmail(faker.internet().emailAddress());
        updateUserRequest.setFirstName(faker.name().firstName());
        updateUserRequest.setLastName(faker.name().lastName());
        updateUserRequest.setPassword("iloveyou");

        updateUserRequest.setUserId(String.valueOf(faker.number().numberBetween(20, 70)));
        updateUserRequest.setUserName(userName);

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "userInfo",
                HttpMethod.PUT,
                new HttpEntity<>(updateUserRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void getUserInfoTest() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

        ResponseEntity<GetUserInfoResponse> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "userInfo",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                GetUserInfoResponse.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void getUserByNameAndIdTest() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

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
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

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
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

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
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

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
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "users",
                HttpMethod.GET,
                new HttpEntity<>(headers), String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
//    @Disabled
    public void deleteUserByIdTest() {
        String userId = "asdasdsa-6727-4229-a4ab-zxczxcxczxcc";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", TOKEN);

        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "user/"+userId,
                HttpMethod.DELETE,
                new HttpEntity<>(headers), String.class);
        Assert.assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
    }
}
