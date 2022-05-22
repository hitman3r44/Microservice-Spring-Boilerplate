package com.wolverine.solutions.accountservice.controller.feature;

import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.PORT;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.SERVER_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.URI;

import com.github.javafaker.Faker;
import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.request.CreateOAuthClientRequest;
import com.wolverine.solutions.accountservice.enums.request.SignUpRequest;
import com.wolverine.solutions.accountservice.service.BaseTest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

@SpringBootTest
public class AuthControllerTest extends BaseTest {

    @Test
    public void testRegisterUser() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        Faker faker = new Faker(new Locale("en-US"));

        SignUpRequest signUpRequest = new SignUpRequest();

        signUpRequest.setEmail(faker.internet().emailAddress());
        signUpRequest.setFirstName(faker.name().firstName());
        signUpRequest.setLastName(faker.name().lastName());
        signUpRequest.setPassword("iloveyou");
        signUpRequest.setUserId(String.valueOf(UUID.randomUUID()));
        signUpRequest.setUserName(faker.name().username());

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "signup",
                HttpMethod.POST,
                new HttpEntity<>(signUpRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

    @Test
    public void testCreateOAuthClient() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        CreateOAuthClientRequest createOAuthClientRequest = new CreateOAuthClientRequest();

        createOAuthClientRequest.setAuthorities(Collections.singletonList("ADMIN_USER"));
        createOAuthClientRequest.setAuthorized_grant_types(Arrays.asList("password",
                "authorization_code", "refresh_token", "client_credentials"));
        createOAuthClientRequest.setResource_ids(Arrays.asList("web", "db"));
        createOAuthClientRequest.setScope(Arrays.asList("read", "write"));

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "client",
                HttpMethod.POST,
                new HttpEntity<>(createOAuthClientRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }
}