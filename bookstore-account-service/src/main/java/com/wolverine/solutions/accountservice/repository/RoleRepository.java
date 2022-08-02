package com.wolverine.solutions.accountservice.repository;

import com.wolverine.solutions.accountservice.enums.entity.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(String name);

    Boolean existsByRoleName(String roleName);

    @Override
    List<Role> findAll();

    @Modifying
    @Query(value = "insert into user_roles (user_id, role_id) values (:user_id, :role_id)", nativeQuery = true)
    @Transactional
    void insertUserRolesTableManually(@Param("user_id") String user_id, @Param("role_id") String role_id);
}