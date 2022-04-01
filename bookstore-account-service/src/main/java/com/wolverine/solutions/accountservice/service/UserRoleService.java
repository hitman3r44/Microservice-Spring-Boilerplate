package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.enums.request.MapRoleToUsersRequest;
import com.wolverine.solutions.accountservice.enums.request.MapUserToRolesRequest;


public interface UserRoleService {

    void mapUserToRoles(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

    void removeRolesFromUser(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

    void mapRoleToUsers(String roleName, MapRoleToUsersRequest mapRoleToUsersRequest);
}