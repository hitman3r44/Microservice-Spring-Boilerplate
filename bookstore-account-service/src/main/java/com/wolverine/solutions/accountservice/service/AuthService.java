package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.enums.request.CreateOAuthClientRequest;
import com.wolverine.solutions.accountservice.enums.request.SignUpRequest;
import com.wolverine.solutions.accountservice.enums.response.CreateOAuthClientResponse;
import com.wolverine.solutions.accountservice.enums.response.CreateUserResponse;

public interface AuthService {

    CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

    CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
