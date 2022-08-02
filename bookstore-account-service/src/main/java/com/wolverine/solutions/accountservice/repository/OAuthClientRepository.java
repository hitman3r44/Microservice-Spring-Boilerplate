package com.wolverine.solutions.accountservice.repository;

import com.wolverine.solutions.accountservice.enums.entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OAuthClientRepository extends JpaRepository<OAuthClient, Long> {
}