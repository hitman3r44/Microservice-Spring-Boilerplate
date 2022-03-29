package com.wolverine.solutions.accountservice.web;

import com.wolverine.solutions.accountservice.repository.dao.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponse {

    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> roles;
    private Boolean isDeleted;
}