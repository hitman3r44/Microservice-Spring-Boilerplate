package com.wolverine.solutions.accountservice.controller;

import com.wolverine.solutions.accountservice.enums.request.CreateOAuthClientRequest;
import com.wolverine.solutions.accountservice.enums.request.SignUpRequest;
import com.wolverine.solutions.accountservice.enums.response.CreateOAuthClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author Sumit Sarkar
 */
public interface AuthController {
    @PostMapping("/client")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    ResponseEntity<CreateOAuthClientResponse> createOAuthClient(
            @Valid @RequestBody CreateOAuthClientRequest createOAuthClientRequest);

    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest);
}