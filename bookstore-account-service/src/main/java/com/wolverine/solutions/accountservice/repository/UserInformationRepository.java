package com.wolverine.solutions.accountservice.repository;

import com.wolverine.solutions.accountservice.enums.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, String> {
    UserInformation findUserInformationByProfilePicture(String profilePicture);
}