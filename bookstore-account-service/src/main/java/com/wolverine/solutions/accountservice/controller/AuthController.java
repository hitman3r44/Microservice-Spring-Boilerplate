package com.wolverine.solutions.accountservice.controller;

import com.wolverine.solutions.accountservice.enums.request.CreateOAuthClientRequest;
import com.wolverine.solutions.accountservice.enums.request.SignUpRequest;
import com.wolverine.solutions.accountservice.enums.response.CreateOAuthClientResponse;
import com.wolverine.solutions.accountservice.enums.response.CreateUserResponse;
import com.wolverine.solutions.accountservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/client")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<CreateOAuthClientResponse> createOAuthClient(
            @Valid @RequestBody CreateOAuthClientRequest createOAuthClientRequest) {
        CreateOAuthClientResponse oAuthClient = authService.createOAuthClient(createOAuthClientRequest);
        return new ResponseEntity<>(oAuthClient, HttpStatus.CREATED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        CreateUserResponse createUserResponse = authService.registerUser(signUpRequest);
        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
    }
}