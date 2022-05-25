package com.wolverine.solutions.accountservice.seeders;

import com.wolverine.solutions.accountservice.enums.entity.Role;
import com.wolverine.solutions.accountservice.enums.entity.User;
import com.wolverine.solutions.accountservice.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Sumit Sarkar
 */
public class UserTableSeeder {
    public static void seedUsersData(UserRepository userRepository) {
        Set<Role> roles;

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));

        userRepository.save(new User(
                "asdasdsa-6727-4229-a4ab-zxczxcxczxcc",
                "Cores",
                "DevD",
                new BCryptPasswordEncoder().encode("admin.devd123"),
                "devd.cores",
                "john.doe@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));
        roles.add(new Role("f4b194d0-238b-41b5-8f18-630e5fcf3d8e", "", ""));

        userRepository.save(new User(
                "xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg",
                "Admin",
                "Admin",
                new BCryptPasswordEncoder().encode("admin.devd123"),
                "admin.admin",
                "admin@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));

        userRepository.save(new User("rertertr-6727-4229-a4ab-erererererer", "Cores", "DevD",
                new BCryptPasswordEncoder().encode("admin.devd123")
                , "devaraj.reddy", "devaraj.reddy@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));

        userRepository.save(new User("cvcvbcvb-ba5d-4b92-85be-fggfgtrytyty", "Admin", "Admin",
                new BCryptPasswordEncoder().encode("admin.devd123")
                , "reddy.devaraj", "reddy.devaraj@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));

        userRepository.save(new User("cvbserte-6727-4229-a4ab-vbnbvvnvbnvb", "Cores", "DevD",
                new BCryptPasswordEncoder().encode("admin.devd123")
                , "rale.reddy", "rale.reddy@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));

        userRepository.save(new User("xcvxvcgv-ba5d-4b92-85be-fghfghtryfgh", "Admin", "Admin",
                new BCryptPasswordEncoder().encode("admin.devd123")
                , "devd.reddy", "devd.reddy@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));

        userRepository.save(new User("ddfgdfgh-6727-4229-a4ab-ertdfgfdgdfg", "Cores", "DevD",
                new BCryptPasswordEncoder().encode("admin.devd123")
                , "reddy.rale", "reddy.rale@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("tytryyrt-rtyr-rtyr-rtyr-fghfghfggfhg", "", ""));

        userRepository.save(new User("dfgdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb", "Admin", "Admin",
                new BCryptPasswordEncoder().encode("admin.devd123")
                , "devd.bro", "devd.bro@gmail.com",
                roles));

        roles = new HashSet<>();
        roles.add(new Role("9601409f-4691-4281-886e-8f8987763b56", "", ""));

        userRepository.save(new User("abcdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb", "Test", "User",
                new BCryptPasswordEncoder().encode("admin.devd123")
                , "test.user", "test.user@gmail.com",
                roles));

        userRepository.save(new User(
                "test.user1",
                new BCryptPasswordEncoder().encode("admin.devd123"),
                "Test1",
                "User",
                "test1.user@gmail.com"));
    }
}
