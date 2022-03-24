-- CREATE USER_PAYMENT_CUSTOMER TABLE
CREATE TABLE IF NOT EXISTS USER_PAYMENT_CUSTOMER (
  ID VARCHAR(255) NOT NULL UNIQUE,
  user_id VARCHAR(255) NOT NULL UNIQUE,
  USER_NAME VARCHAR(255) NOT NULL UNIQUE,
  PAYMENT_CUSTOMER_ID  VARCHAR(255) NOT NULL UNIQUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX USER_PAYMENT_CUSTOMER_USER_ID_INDEX ON USER_PAYMENT_CUSTOMER (user_id);
