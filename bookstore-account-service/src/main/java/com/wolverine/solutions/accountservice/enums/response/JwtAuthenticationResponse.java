package com.wolverine.solutions.accountservice.enums.response;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor
//@AllArgsConstructor
public class JwtAuthenticationResponse {

    String access_token = null;
    String token_type = "Bearer";
    String refresh_token = null;
    Long expires_in = null;
}