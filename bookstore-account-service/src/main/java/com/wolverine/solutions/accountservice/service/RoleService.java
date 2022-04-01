package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.dao.Role;
import com.wolverine.solutions.accountservice.web.CreateRoleRequest;

import java.util.List;


public interface RoleService {

    String createRole(CreateRoleRequest createRoleRequest);

    List<Role> getAllRoles();
}
