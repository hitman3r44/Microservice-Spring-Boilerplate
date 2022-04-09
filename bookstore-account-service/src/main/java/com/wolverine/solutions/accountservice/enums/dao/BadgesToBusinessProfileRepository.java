package com.wolverine.solutions.accountservice.enums.dao;

import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesToBusinessProfileRepository extends PagingAndSortingRepository<BadgesToBusinessProfile, String> {
}