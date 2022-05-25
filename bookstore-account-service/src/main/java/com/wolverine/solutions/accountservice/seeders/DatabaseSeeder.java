package com.wolverine.solutions.accountservice.seeders;

import com.wolverine.solutions.accountservice.repository.RoleRepository;
import com.wolverine.solutions.accountservice.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Sumit Sarkar
 */
@Log4j2
@Component
public class DatabaseSeeder {
    private final UserRepository userRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    RoleRepository roleRepository;

    public DatabaseSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    @EventListener
    public void seed(ContextRefreshedEvent event) {
        RoleTableSeeder.seedRoleData(roleRepository);
        UserTableSeeder.seedUsersData(userRepository);
//        UserRoleMappingTableSeeder userRoleMappingTableSeeder = new UserRoleMappingTableSeeder();
//        userRoleMappingTableSeeder.seedUserRoleMappingData(jdbcTemplate) ;
    }
}