package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.enums.entity.Role;
import com.wolverine.solutions.accountservice.enums.request.CreateRoleRequest;

import java.util.List;


public interface RoleService {

    String createRole(CreateRoleRequest createRoleRequest);

    List<Role> getAllRoles();
}
