package com.wolverine.solutions.accountservice.repository.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wolverine.solutions.commons.util.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


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
  @Column(name = "CLIENT_ID", updatable = false, nullable = false)
  private String client_id;

  @Column(name = "CLIENT_SECRET", updatable = false, nullable = false)
  private String client_secret;
  @Column(name = "AUTHORIZED_GRANT_TYPES", updatable = false, nullable = false)
  private String authorized_grant_types;
  private String authorities;
  @Column(name = "SCOPE", updatable = false, nullable = false)
  private String scope;
  private String resource_ids;
  private String web_server_redirect_uri;
  private String access_token_validity;
  private String refresh_token_validity;
  private String additional_information;
  @Column(name = "AUTO_APPROVE", updatable = false, nullable = false)
  private String auto_approve;

}
