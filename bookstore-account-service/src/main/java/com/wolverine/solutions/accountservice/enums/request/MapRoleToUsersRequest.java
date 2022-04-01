package com.wolverine.solutions.accountservice.enums.request;

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