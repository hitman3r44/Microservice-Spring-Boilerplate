package com.wolverine.solutions.accountservice.repository;

import com.wolverine.solutions.accountservice.enums.entity.UserInformation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends PagingAndSortingRepository<UserInformation, String> {
}