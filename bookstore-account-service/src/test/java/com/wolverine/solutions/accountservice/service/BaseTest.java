package com.wolverine.solutions.accountservice.service;

import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.PORT;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.SERVER_NAME;
import static com.wolverine.solutions.accountservice.enums.ConstentVariableTests.URI;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

import com.wolverine.solutions.accountservice.enums.ConstentVariableTests;
import com.wolverine.solutions.accountservice.enums.response.JwtAuthenticationResponse;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

/**
 * @author Sumit Sarkar
 */
public class BaseTest implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean started = false;
    private static boolean isNewTokenGenerated = false;
    private static String TOKEN = "Bearer ";

    // TODO: Not working need to check
    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            TOKEN = getNewToken();

            // The following line registers a callback hook when the root test context is shut down
            context.getRoot().getStore(GLOBAL).put("any_unique_name", this);
        }
    }

    public static MultiValueMap<String, String> getRequestHeader(String contentType) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", contentType);
        headers.add("Authorization", getNewToken());
        return headers;
    }

    public static String getNewToken() {
        if (!isNewTokenGenerated && !StringUtils.isEmpty(TOKEN)) {
            String loginToken = "Basic OTNlZDQ1M2UtYjdhYy00MTkyLWE2ZDQtYzQ1ZmFlMGQ5OWFjOmNsaWVudC5kZXZkMTIz";
            JwtAuthenticationResponse jwtAuthenticationResponse;
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

            body.add("grant_type", "password");
            body.add("username", "admin.admin");
            body.add("password", "admin.devd123");

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

            headers.add("Content-Type", ConstentVariableTests.APPLICATION_X_WWW_FORM_URLENCODED);
            headers.add("Authorization", loginToken);

            ResponseEntity<?> entity = new TestRestTemplate().exchange(
                    SERVER_NAME + PORT + URI + "oauth/token",
                    HttpMethod.POST,
                    new HttpEntity<>(body, headers),
                    new ParameterizedTypeReference<JwtAuthenticationResponse>() {
                    });

            jwtAuthenticationResponse = (JwtAuthenticationResponse) entity.getBody();
            assert jwtAuthenticationResponse != null;
            isNewTokenGenerated = true;
            String TOKEN_TYPE = jwtAuthenticationResponse.getToken_type();
            return TOKEN = TOKEN_TYPE + " " + jwtAuthenticationResponse.getAccess_token();
        }
        return TOKEN;
    }

    @Override
    public void close() {
        System.out.println("Closing Test...");
    }
}