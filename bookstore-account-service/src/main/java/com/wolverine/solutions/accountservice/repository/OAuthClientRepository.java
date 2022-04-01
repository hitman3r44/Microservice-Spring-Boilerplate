package com.wolverine.solutions.accountservice.repository;

import com.wolverine.solutions.accountservice.enums.entity.OAuthClient;
import org.springframework.data.repository.CrudRepository;


public interface OAuthClientRepository extends CrudRepository<OAuthClient, Long> {
}