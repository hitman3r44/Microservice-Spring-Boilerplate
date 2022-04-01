package com.wolverine.solutions.accountservice.controller.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolverine.solutions.accountservice.controller.RoleController;
import com.wolverine.solutions.accountservice.enums.request.CreateRoleRequest;
import com.wolverine.solutions.accountservice.service.RoleService;
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

@ContextConfiguration(classes = {RoleController.class})
@ExtendWith(SpringExtension.class)
class RoleControllerTest {
    @Autowired
    private RoleController roleController;

    @MockBean
    private RoleService roleService;

    @Test
    void testCreateRole() throws Exception {
        when(this.roleService.createRole(any())).thenReturn("Create Role");

        CreateRoleRequest createRoleRequest = new CreateRoleRequest();
        createRoleRequest.setRoleDescription("Role Description");
        createRoleRequest.setRoleName("Role Name");
        String content = (new ObjectMapper()).writeValueAsString(createRoleRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/role")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/role/Create%20Role"));
    }

    @Test
    void testGetAllRoles() throws Exception {
        when(this.roleService.getAllRoles()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/roles");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllRoles2() throws Exception {
        when(this.roleService.getAllRoles()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/roles");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

