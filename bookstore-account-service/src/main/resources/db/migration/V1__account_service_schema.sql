-- noinspection SqlNoDataSourceInspectionForFile

-- CREATE user TABLE
CREATE TABLE IF NOT EXISTS user (
	user_id VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE ,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255),
	password VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL UNIQUE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (user_id)
);

CREATE UNIQUE INDEX user_id_index ON user (user_id);

-- CREATE role TABLE
CREATE TABLE IF NOT EXISTS role (
	role_id VARCHAR(255) NOT NULL,
	role_description VARCHAR(255),
	role_name VARCHAR(255) NOT NULL UNIQUE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (role_id)
);
CREATE UNIQUE INDEX role_id_index ON role (role_id);

-- CREATE user-ROLES MAPPING TABLE
CREATE TABLE IF NOT EXISTS user_roles (
	user_id VARCHAR(255) NOT NULL,
	role_id VARCHAR(255) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT USER_FK FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT ROLE_FK FOREIGN KEY (role_id) REFERENCES role (role_id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX USER_FK_INDEX ON user_roles (user_id);
CREATE INDEX ROLE_FK_INDEX ON user_roles (role_id);

-- CREATE OAUTH_CLIENT_DETAILS TABLE
CREATE TABLE IF NOT EXISTS oauth_client_details (
    client_id VARCHAR(255) PRIMARY KEY,
    resource_ids VARCHAR(255),
    client_secret VARCHAR(255),
    scope VARCHAR(255),
    authorized_grant_types VARCHAR(255),
    web_server_redirect_uri VARCHAR(255),
    authorities VARCHAR(255),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
