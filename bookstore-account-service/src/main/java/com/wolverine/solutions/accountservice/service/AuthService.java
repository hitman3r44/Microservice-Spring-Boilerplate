package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.web.CreateOAuthClientRequest;
import com.wolverine.solutions.accountservice.web.CreateOAuthClientResponse;
import com.wolverine.solutions.accountservice.web.CreateUserResponse;
import com.wolverine.solutions.accountservice.web.SignUpRequest;

public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
