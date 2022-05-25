package com.wolverine.solutions.accountservice.seeders;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Sumit Sarkar
 */
@Component
public class UserRoleMappingTableSeeder {
    //    @Autowired
//    JdbcTemplate jdbcTemplate;
    @Transactional
    public void seedUserRoleMappingData(JdbcTemplate jdbcTemplate) {

        jdbcTemplate.execute("INSERT INTO user_roles(user_id, role_id)\n" +
                "VALUES ('asdasdsa-6727-4229-a4ab-zxczxcxczxcc', '9601409f-4691-4281-886e-8f8987763b56')");
        jdbcTemplate.execute("INSERT INTO user_roles(user_id, role_id)\n" +
                "VALUES ('xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg', '9601409f-4691-4281-886e-8f8987763b56')");


//        roleRepository.insertUserRolesTableManually("xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg",
//                "9601409f-4691-4281-886e-8f8987763b56");
//        roleRepository.insertUserRolesTableManually("xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg",
//                "f4b194d0-238b-41b5-8f18-630e5fcf3d8e");
//        roleRepository.insertUserRolesTableManually("rertertr-6727-4229-a4ab-erererererer",
//                "9601409f-4691-4281-886e-8f8987763b56");
//        roleRepository.insertUserRolesTableManually("dfgdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb",
//                "tytryyrt-rtyr-rtyr-rtyr-fghfghfggfhg");
//        roleRepository.insertUserRolesTableManually("abcdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb",
//                "9601409f-4691-4281-886e-8f8987763b56");
    }
}
