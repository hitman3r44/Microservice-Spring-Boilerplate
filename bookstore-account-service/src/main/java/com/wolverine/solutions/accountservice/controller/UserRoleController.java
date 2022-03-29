package com.wolverine.solutions.accountservice.controller;

import com.wolverine.solutions.accountservice.service.UserRoleService;
import com.wolverine.solutions.accountservice.web.MapRoleToUsersRequest;
import com.wolverine.solutions.accountservice.web.MapUserToRolesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping("/user/{userNameOrEmail}/roles")
    public void mapUserToRoles(@PathVariable("userNameOrEmail") String userNameOrEmail,
                               @RequestBody @Valid MapUserToRolesRequest mapUserToRolesRequest) {
        userRoleService.mapUserToRoles(userNameOrEmail, mapUserToRolesRequest);
    }

    @PostMapping("/role/{roleName}/users")
    public void mapRoleToUsers(@PathVariable("roleName") String roleName,
                               @RequestBody @Valid MapRoleToUsersRequest mapRoleToUsersRequest) {
        userRoleService.mapRoleToUsers(roleName, mapRoleToUsersRequest);
    }
}