package com.wolverine.solutions.accountservice.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserResponse {

  private String userId;
  private String userName;

}
