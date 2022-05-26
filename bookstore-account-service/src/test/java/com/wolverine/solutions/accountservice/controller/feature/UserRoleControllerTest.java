package com.wolverine.solutions.accountservice.controller.feature;

import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.PORT;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.SERVER_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.TEST_ROLE_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.TEST_USER_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.URI;
import static com.wolverine.solutions.accountservice.service.BaseTest.getRequestHeader;

import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.request.MapRoleToUsersRequest;
import com.wolverine.solutions.accountservice.enums.request.MapUserToRolesRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class UserRoleControllerTest {
    @Test
    public void testMapUserToRoles() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        MapUserToRolesRequest mapUserToRolesRequest = new MapUserToRolesRequest();
        mapUserToRolesRequest.setRoleNames(new ArrayList<>(Arrays.asList("STANDARD_USER", "ADMIN_USER")));

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "/user/" + TEST_USER_NAME + "/roles",
                HttpMethod.POST,
                new HttpEntity<>(mapUserToRolesRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void testMapRoleToUsers() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);

        MapRoleToUsersRequest mapRoleToUsersRequest = new MapRoleToUsersRequest();
        mapRoleToUsersRequest.setUserNames(new ArrayList<>(Collections.singletonList(TEST_USER_NAME)));

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + "/role/" + TEST_ROLE_NAME + "/users",
                HttpMethod.POST,
                new HttpEntity<>(mapRoleToUsersRequest, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}