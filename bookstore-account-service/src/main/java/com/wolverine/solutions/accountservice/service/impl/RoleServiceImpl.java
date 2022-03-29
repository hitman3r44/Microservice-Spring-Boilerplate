package com.wolverine.solutions.accountservice.service.impl;

import com.wolverine.solutions.accountservice.repository.RoleRepository;
import com.wolverine.solutions.accountservice.repository.dao.Role;
import com.wolverine.solutions.accountservice.service.RoleService;
import com.wolverine.solutions.accountservice.web.CreateRoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public String createRole(CreateRoleRequest createRoleRequest) {

        Role role = Role.builder()
                .roleName(createRoleRequest.getRoleName())
                .roleDescription(createRoleRequest.getRoleDescription())
                .build();

        Role savedRole = roleRepository.save(role);
        return savedRole.getId();
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> allRoles = roleRepository.findAll();
        return allRoles;
    }
}