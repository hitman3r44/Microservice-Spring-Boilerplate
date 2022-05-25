package com.wolverine.solutions.accountservice.seeders;

import com.wolverine.solutions.accountservice.enums.entity.Role;
import com.wolverine.solutions.accountservice.repository.RoleRepository;

/**
 * @author Sumit Sarkar
 */
public class RoleTableSeeder {
    public static void seedRoleData(RoleRepository roleRepository) {
        roleRepository.save(
                new Role("9601409f-4691-4281-886e-8f8987763b56",
                        "STANDARD_USER",
                        "Standard User - Has no admin rights")
        );


        roleRepository.save(
                new Role("f4b194d0-238b-41b5-8f18-630e5fcf3d8e",
                        "ADMIN_USER",
                        "Admin User - Has permission to perform admin tasks")
        );

        roleRepository.save(
                new Role("erwerwer-erer-erfd-8f18-cvbdfgdgfggg",
                        "SELLER",
                        "Seller who can manage his inventory")
        );

        roleRepository.save(
                new Role("tytryyrt-rtyr-rtyr-rtyr-fghfghfggfhg",
                        "PRODUCT_OWNER",
                        "Product Owner")
        );
    }
}
