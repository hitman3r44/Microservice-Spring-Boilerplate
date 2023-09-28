INSERT INTO user (user_id, first_name, last_name, password, user_name, email)
VALUES ('asdasdsa-6727-4229-a4ab-zxczxcxczxcc', 'Cores', 'DevD',
        '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'devd.cores', 'john.doe@gmail.com'),
       ('xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg', 'Admin', 'Admin',
        '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'admin.admin', 'admin@gmail.com'),
       ('rertertr-6727-4229-a4ab-erererererer', 'Cores', 'DevD',
        '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'devaraj.reddy', 'devaraj.reddy@gmail.com'),
       ('cvcvbcvb-ba5d-4b92-85be-fggfgtrytyty', 'Admin', 'Admin',
        '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'reddy.devaraj', 'reddy.devaraj@gmail.com'),
       ('cvbserte-6727-4229-a4ab-vbnbvvnvbnvb', 'Cores', 'DevD',
        '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'rale.reddy', 'rale.reddy@gmail.com'),
       ('xcvxvcgv-ba5d-4b92-85be-fghfghtryfgh', 'Admin', 'Admin',
        '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'devd.reddy', 'devd.reddy@gmail.com'),
       ('ddfgdfgh-6727-4229-a4ab-ertdfgfdgdfg', 'Cores', 'DevD',
        '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'reddy.rale', 'reddy.rale@gmail.com'),
       ('dfgdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb', 'Admin', 'Admin',
        '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'devd.bro', 'devd.bro@gmail.com'),
       ('abcdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb', 'Test', 'User',
        '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'test.user', 'test.user@gmail.com');

INSERT INTO role (role_id, role_name, role_description)
VALUES ('9601409f-4691-4281-886e-8f8987763b56', 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO role (role_id, role_name, role_description)
VALUES ('f4b194d0-238b-41b5-8f18-630e5fcf3d8e', 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');
INSERT INTO role (role_id, role_name, role_description)
VALUES ('erwerwer-erer-erfd-8f18-cvbdfgdgfggg', 'SELLER', 'Seller who can manage his inventory');
INSERT INTO role (role_id, role_name, role_description)
VALUES ('tytryyrt-rtyr-rtyr-rtyr-fghfghfggfhg', 'PRODUCT_OWNER', 'Product Owner');

INSERT INTO user_roles(user_id, role_id)
VALUES ('asdasdsa-6727-4229-a4ab-zxczxcxczxcc', '9601409f-4691-4281-886e-8f8987763b56');
INSERT INTO user_roles(user_id, role_id)
VALUES ('xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg', '9601409f-4691-4281-886e-8f8987763b56');
INSERT INTO user_roles(user_id, role_id)
VALUES ('xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg', 'f4b194d0-238b-41b5-8f18-630e5fcf3d8e');
INSERT INTO user_roles(user_id, role_id)
VALUES ('rertertr-6727-4229-a4ab-erererererer', '9601409f-4691-4281-886e-8f8987763b56');
INSERT INTO user_roles(user_id, role_id)
VALUES ('dfgdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb', 'tytryyrt-rtyr-rtyr-rtyr-fghfghfggfhg');
INSERT INTO user_roles(user_id, role_id)
VALUES ('abcdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb', '9601409f-4691-4281-886e-8f8987763b56');

INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri,
                                  authorities, access_token_validity, refresh_token_validity, additional_information,
                                  autoapprove, resource_ids)
VALUES ('93ed453e-b7ac-4192-a6d4-c45fae0d99ac', '$2a$10$LulvWhcpUv8lFGmd9NbIG.PB46E5/tcivjGbELWMMWeBuDHKtrVKa',
        'read,write', 'password,authorization_code,refresh_token,client_credentials', 'http://localhost:5678',
        'ADMIN_USER', 259200, 604800, null, true, 'web');


insert into BUSINESS_PROFILE (ID, CREATED_AT, IS_DELETED, UPDATED_AT, BIO, CITY, CONTACT_PERSON, EMAIL, EMPLOYMENT_SIZE,
                              FOLLOWERS, FOUNDATION_YEAR, HEADER_IMAGE, ISPUBLISH, LOGO, LONG_DESCRIPTION, NAME, PHONE,
                              PHOTO_URL, POSTAL_CODE, PROVINCE, RATING, SHORT_DESCRIPTION, STATUS, STREET_NAME,
                              STREET_NUMBER, USER_ID, WEBSITE)
values ('c888f661-ce92-4334-a45e-e971f2aed1d4','2023-02-27 01:44:15.118799','false','2023-02-27 01:44:15.131216','technical savvy','New Brittaniestad','sonja.anderson','milford.bradtke@hotmail.com','334','9','6','http://lorempixel.com/g/1280/1024/animals/','false','https://pigment.github.io/fake-logos/logos/medium/color/11.png','Hail','Mr. Casie Auer','(573) 341-7603','','76351-0138','Texas','2','Clear skies','Dragonite','Jasmine Forges','757','bb17a502-f97d-4098-be31-0546ff9ce807','auer.name');

insert into BADGES_TO_BUSINESS_PROFILE (ID, CREATED_AT, IS_DELETED, UPDATED_AT, BADGE_NAME, BUSINESS_PROFILE_ID)
values ('aec80b4f-eb59-4b9d-b6ba-b1883afe99a3','2023-02-27 01:44:15.120445',false,'2023-02-27 01:44:15.120445','Badge One ','c888f661-ce92-4334-a45e-e971f2aed1d4');

insert into BADGES_TO_BUSINESS_PROFILE (ID, CREATED_AT, IS_DELETED, UPDATED_AT, BADGE_NAME, BUSINESS_PROFILE_ID)
values ('0d1ded76-0af8-4a5e-af64-2b2f37122554','2023-02-27 01:44:15.120445',false,'2023-02-27 01:44:15.120445','Badge Two ','c888f661-ce92-4334-a45e-e971f2aed1d4');

insert into TAGS_TO_BUSINESS_PROFILE (ID, CREATED_AT, IS_DELETED, UPDATED_AT, BUSINESS_PROFILE_ID)
values ('5d1ded76-0af9-4a5f-af65-2b2f37122556','2023-02-27 01:44:15.120445',false,'2023-02-27 01:44:15.120445','c888f661-ce92-4334-a45e-e971f2aed1d4');

insert into TAGS_TO_BUSINESS_PROFILE (ID, CREATED_AT, IS_DELETED, UPDATED_AT, BUSINESS_PROFILE_ID)
values ('6d1ded79-1af1-5a5g-bf66-3b2f37122557','2023-02-27 01:44:15.120445',false,'2023-02-27 01:44:15.120445','c888f661-ce92-4334-a45e-e971f2aed1d4');