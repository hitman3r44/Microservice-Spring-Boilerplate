package com.wolverine.solutions.accountservice.controller.feature;

import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.PAGE_QUERY;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.PORT;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.SERVER_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.URI;

import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import com.wolverine.solutions.accountservice.service.BaseTest;
import com.wolverine.solutions.accountservice.service.BusinessProfileObjGenerator;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BusinessProfileControllerTest extends BaseTest {

    @Test
    @Order(1)
    public void saveTest() {
        MultiValueMap<String, String> headers = getRequestHeader(
                ConstentVariableTests.APPLICATION_JSON);
        IntStream.range(0, 5).forEach(i -> BusinessProfileObjGenerator.saveFunctionBody(headers));
    }

    @Test
    @Order(2)
    public void testDeleteById() {
        MultiValueMap<String, String> headers = getRequestHeader(
                ConstentVariableTests.APPLICATION_JSON);
        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + ConstentVariableTests.CONTROLLER_ROUTE + ConstentVariableTests.lastID,
                HttpMethod.DELETE,
                new HttpEntity<>(headers), String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

//    @Test
//    @Order(3)
//    public void testRestoreById() {
//        MultiValueMap<String, String> headers = getRequestHeader(
//                ConstentVariableTests.APPLICATION_JSON);
//        ResponseEntity<String> entity = new TestRestTemplate().exchange(
//                SERVER_NAME + PORT + URI + CONTROLLER_ROUTE + lastID,
//                HttpMethod.PATCH,
//                new HttpEntity<>(headers), String.class);
//        Assert.assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
//    }

    @Test
    public void findByIdTest() {
        MultiValueMap<String, String> headers = getRequestHeader(
                ConstentVariableTests.APPLICATION_JSON);
        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + ConstentVariableTests.CONTROLLER_ROUTE +
//                        "ac95c2ad-70a1-4fa6-80d5-e46c90b0397e",
                        ConstentVariableTests.lastID,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                BusinessProfile.class);

        BusinessProfileObjGenerator.objectToJsonMapper((BusinessProfile) entity.getBody(), ConstentVariableTests.jsonDumpFileName + "_findByIdTest()");
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void testList() {
        MultiValueMap<String, String> headers = getRequestHeader(
                ConstentVariableTests.APPLICATION_JSON);
        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + ConstentVariableTests.CONTROLLER_ROUTE,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

//    objectToJsonMapper((BusinessProfile) entity.getBody(), jsonDumpFileName + "_testList()");

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void testPageQuery() {
        MultiValueMap<String, String> headers = getRequestHeader(
                ConstentVariableTests.APPLICATION_JSON);
        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + ConstentVariableTests.CONTROLLER_ROUTE + PAGE_QUERY,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void testUpdate() {
        MultiValueMap<String, String> headers = getRequestHeader(
                ConstentVariableTests.APPLICATION_JSON);

        BusinessProfileDTO businessProfileDTO = BusinessProfileObjGenerator.generateBusinessProfileDTO();
        businessProfileDTO.setId(ConstentVariableTests.lastID);

        ResponseEntity<?> entity = new TestRestTemplate().exchange(
                SERVER_NAME + PORT + URI + ConstentVariableTests.CONTROLLER_ROUTE + ConstentVariableTests.lastID,
                HttpMethod.PUT,
                new HttpEntity<>(businessProfileDTO, headers),
                String.class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        ConstentVariableTests.lastID = businessProfileDTO.getId();
    }
}

