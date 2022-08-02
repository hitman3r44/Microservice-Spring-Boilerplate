package com.wolverine.solutions.accountservice.enums.dao;

import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesToBusinessProfileRepository extends JpaRepository<BadgesToBusinessProfile, String> {
}