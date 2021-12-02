package com.wolverine.solutions.accountservice.web;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapUserToRolesRequest {

  private List<String> roleNames;
}
