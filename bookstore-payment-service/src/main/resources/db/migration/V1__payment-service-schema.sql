-- CREATE user_payment_customer TABLE
CREATE TABLE IF NOT EXISTS user_payment_customer (
  id VARCHAR(255) NOT NULL UNIQUE,
  user_id VARCHAR(255) NOT NULL UNIQUE,
  user_name VARCHAR(255) NOT NULL UNIQUE,
  payment_customer_id  VARCHAR(255) NOT NULL UNIQUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX USER_PAYMENT_CUSTOMER_USER_ID_INDEX ON user_payment_customer (user_id);
