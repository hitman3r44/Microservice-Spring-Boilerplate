-- create address table
CREATE TABLE IF NOT EXISTS address (
    address_id VARCHAR(255) NOT NULL,
    address_line1 VARCHAR(255) NOT NULL,
    address_line2 VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    phone VARCHAR(255),
    postal_code VARCHAR(255),
    state VARCHAR(255),
    user_id VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (address_id)
);
