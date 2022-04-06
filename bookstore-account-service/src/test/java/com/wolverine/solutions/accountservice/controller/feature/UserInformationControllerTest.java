package com.wolverine.solutions.accountservice.controller.feature;

import com.github.javafaker.Faker;
import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.dto.UserInformationDTO;
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

    @Test
    public void saveTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        IntStream.range(0, 500).forEach(i -> saveFunctionBody(headers));
    }

    private void saveFunctionBody(MultiValueMap<String, String> headers) {
        UserInformationDTO userInformationDTO = new UserInformationDTO();
        userInformationDTO.setId(String.valueOf(UUID.randomUUID()));
        userInformationDTO.setProfilePicture(faker.name().nameWithMiddle());

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE,
                HttpMethod.POST,
                new HttpEntity<>(userInformationDTO, headers),
                String.class);

        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

    @Test
    public void findByIdTest() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        String userInfoId = "9a6ded81-617d-4eb1-a381-769247d8fe54";

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + userInfoId,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void testUpdate() {
        MultiValueMap<String, String> headers = getRequestHeader(ConstentVariableTests.APPLICATION_JSON);
        String userInfoId = "bb3b3d72-0c15-4c5b-8ff2-1e4ade51161c";

        UserInformationDTO userInformationDTO = new UserInformationDTO();
        userInformationDTO.setId(userInfoId);
        userInformationDTO.setProfilePicture("UpdatedWithDate");

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + userInfoId,
                HttpMethod.PUT,
                new HttpEntity<>(userInformationDTO, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
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
                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + "page-query?page=1&size=2&sort=profilePicture,asc",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

//    @Test
//    public void testDelete() throws Exception {
//        doNothing().when(this.userInformationService).deleteById((String) any());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/user-information/{id}", "42");
//        MockMvcBuilders.standaloneSetup(this.userInformationControllerImpl)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}