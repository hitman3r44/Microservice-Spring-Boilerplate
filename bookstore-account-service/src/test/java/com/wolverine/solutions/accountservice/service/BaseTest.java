package com.wolverine.solutions.accountservice.service;

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

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

/**
 * @author Sumit Sarkar
 */
public class BaseTest implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean started = false;
    private static boolean isNewTokenGenerated = false;
    public static String TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsid2ViIl0sInVzZXJfaWQiOiJ4Y3ZjdmJ2di1iYTVkLTRiOTItODViZS1kZmdkZmdkZmdkZmciLCJ1c2VyX25hbWUiOiJhZG1pbi5hZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE2NDg5NjU3NTgsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6IkE1VENyNmhNNVRIaV9rRk1NMlIxUERYLWxWOCIsImNsaWVudF9pZCI6IjkzZWQ0NTNlLWI3YWMtNDE5Mi1hNmQ0LWM0NWZhZTBkOTlhYyJ9.D64UgnfVUzqUVPHQsC7ShmE05AFqfNSIX6ozzscqI-TjAmuyZtStRyReW4SgYW22P78JzvxbNLWpnrmBUuU-TcjnAxiYZBSWobDQL1mEPNH3_arXDqQo0CFmjHqaE333I-dKi6LZY4kiua_V-jmMjlMWbZeQYKGz9makRHdlAkjncLqfk6uEfuCrg-5RXkl9bWjfleBwgZHDmu1ggtKxoOf6sxNKMGAxb8giwNEuoxGwi8eGkx2SiteFCU2u5hqVDiXOfjOCCTnisAPkFe1jLhl0YaJdkchfCp4V1kvEKLYwT2lRyjgK3PYw7k6rybl4BIBYeeIrlB9YP-FsrLMuJw";
    public static final String SERVER_NAME = "http://localhost:";
    public static final String PORT = "8765";
    public static final String URI = "/api/account/";
    private static String TOKEN_TYPE = "Bearer";

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
            TOKEN_TYPE = jwtAuthenticationResponse.getToken_type();
            return TOKEN = TOKEN_TYPE +" "+ jwtAuthenticationResponse.getAccess_token();
        }
        return TOKEN;
    }

    @Override
    public void close() {
        System.out.println("Closing Test...");
    }
}