package com.wolverine.solutions.accountservice.controller.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolverine.solutions.accountservice.controller.UserRoleController;
import com.wolverine.solutions.accountservice.enums.request.MapRoleToUsersRequest;
import com.wolverine.solutions.accountservice.enums.request.MapUserToRolesRequest;
import com.wolverine.solutions.accountservice.service.UserRoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;

@ContextConfiguration(classes = {UserRoleController.class})
@ExtendWith(SpringExtension.class)
class UserRoleControllerTest {
    @Autowired
    private UserRoleController userRoleController;

    @MockBean
    private UserRoleService userRoleService;

    @Test
    void testMapUserToRoles() throws Exception {
        doNothing().when(this.userRoleService).mapUserToRoles(any(), any());

        MapUserToRolesRequest mapUserToRolesRequest = new MapUserToRolesRequest();
        mapUserToRolesRequest.setRoleNames(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(mapUserToRolesRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/{userNameOrEmail}/roles", "janedoe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userRoleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testMapRoleToUsers() throws Exception {
        doNothing().when(this.userRoleService).mapRoleToUsers(any(), any());

        MapRoleToUsersRequest mapRoleToUsersRequest = new MapRoleToUsersRequest();
        mapRoleToUsersRequest.setUserNames(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(mapRoleToUsersRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/role/{roleName}/users", "Role Name")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userRoleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

