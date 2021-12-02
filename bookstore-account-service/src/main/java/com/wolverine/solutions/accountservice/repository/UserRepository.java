package com.wolverine.solutions.accountservice.repository;


import com.wolverine.solutions.accountservice.repository.dao.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUserName(String username);

  Optional<User> findByUserNameOrEmail(String uName, String eMail);

  Optional<User> findByUserId(String userId);

  void deleteByUserId(String userId);

  Boolean existsByUserName(String userName);

  Boolean existsByEmail(String email);

}
