package com.wolverine.solutions.accountservice.enums.entity;

import com.wolverine.solutions.commons.util.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oauth_client_details")
@Builder
public class OAuthClient extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "client_id", updatable = false, nullable = false)
    private String client_id;

    @Column(name = "client_secret", updatable = false, nullable = false)
    private String client_secret;
    @Column(name = "authorized_grant_types", updatable = false, nullable = false)
    private String authorized_grant_types;
    @Column(name = "authorities")
    private String authorities;
    @Column(name = "scope", updatable = false, nullable = false)
    private String scope;
    @Column(name = "resource_ids")
    private String resource_ids;
    @Column(name = "web_server_redirect_uri")
    private String web_server_redirect_uri;
    @Column(name = "access_token_validity")
    private String access_token_validity;
    @Column(name = "refresh_token_validity")
    private String refresh_token_validity;
    @Column(name = "additional_information")
    private String additional_information;
    @Column(name = "autoapprove", updatable = false, nullable = false)
    private String auto_approve;
}