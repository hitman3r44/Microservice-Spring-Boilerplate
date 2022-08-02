package com.wolverine.solutions.accountservice.enums.dao;

import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessProfileRepository extends JpaRepository<BusinessProfile, String> {
}