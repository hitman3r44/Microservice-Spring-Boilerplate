package com.wolverine.solutions.accountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapRoleToUsersRequest {

    private List<String> userNames;
}