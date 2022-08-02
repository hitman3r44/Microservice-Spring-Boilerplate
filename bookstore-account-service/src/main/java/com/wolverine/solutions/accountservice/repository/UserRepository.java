package com.wolverine.solutions.accountservice.repository;


import com.wolverine.solutions.accountservice.enums.entity.User;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Optional<User> findByUserNameOrEmail(String uName, String eMail);

    Optional<User> findByUserId(String userId);

    void deleteByUserId(String userId);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}