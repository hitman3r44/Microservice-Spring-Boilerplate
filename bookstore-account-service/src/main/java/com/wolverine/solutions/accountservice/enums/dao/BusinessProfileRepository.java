package com.wolverine.solutions.accountservice.enums.dao;

import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessProfileRepository extends PagingAndSortingRepository<BusinessProfile, String> {
}