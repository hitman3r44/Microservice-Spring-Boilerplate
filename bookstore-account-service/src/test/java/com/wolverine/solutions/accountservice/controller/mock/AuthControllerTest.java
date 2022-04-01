package com.wolverine.solutions.accountservice.controller.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolverine.solutions.accountservice.controller.AuthController;
import com.wolverine.solutions.accountservice.enums.request.CreateOAuthClientRequest;
import com.wolverine.solutions.accountservice.enums.request.SignUpRequest;
import com.wolverine.solutions.accountservice.enums.response.CreateOAuthClientResponse;
import com.wolverine.solutions.accountservice.enums.response.CreateUserResponse;
import com.wolverine.solutions.accountservice.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthService authService;

    @Test
    void testCreateOAuthClient() throws Exception {
        when(this.authService.createOAuthClient(any()))
                .thenReturn(new CreateOAuthClientResponse("Client id", "Client secret"));

        CreateOAuthClientRequest createOAuthClientRequest = new CreateOAuthClientRequest();
        createOAuthClientRequest.setAuthorities(new ArrayList<>());
        createOAuthClientRequest.setAuthorized_grant_types(new ArrayList<>());
        createOAuthClientRequest.setResource_ids(new ArrayList<>());
        createOAuthClientRequest.setScope(new ArrayList<>());

        String content = (new ObjectMapper()).writeValueAsString(createOAuthClientRequest);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"client_id\":\"Client id\",\"client_secret\":\"Client secret\"}"));
    }

    @Test
    void testRegisterUser() throws Exception {
        when(this.authService.registerUser(any())).thenReturn(new CreateUserResponse("42", "janedoe"));

        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail("jane.doe@example.org");
        signUpRequest.setFirstName("Jane");
        signUpRequest.setLastName("Doe");
        signUpRequest.setPassword("iloveyou");
        signUpRequest.setUserId("42");
        signUpRequest.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(signUpRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"userId\":\"42\",\"userName\":\"janedoe\"}"));
    }
}

