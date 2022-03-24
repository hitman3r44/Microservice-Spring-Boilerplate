-- create cart table
CREATE TABLE IF NOT EXISTS cart (
    cart_id VARCHAR(255) NOT NULL,
    total_price DOUBLE NOT NULL,
    user_name VARCHAR(255) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (cart_id, user_name)
);

-- create cart item table
CREATE TABLE IF NOT EXISTS cart_item (
    cart_item_id VARCHAR(255) NOT NULL,
    item_price DOUBLE NOT NULL,
    extended_price DOUBLE NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    cart_id VARCHAR(255),
    PRIMARY KEY (cart_item_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT CART_FK FOREIGN KEY (cart_id) REFERENCES cart (cart_id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- create order table
CREATE TABLE IF NOT EXISTS order_table (
    order_id VARCHAR(255) NOT NULL,
    total_order_price DOUBLE NOT NULL,
    total_items_price DOUBLE NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    payment_method_id VARCHAR(255),
    tax_price DOUBLE,
    shipping_price DOUBLE,
    is_paid TINYINT(1) DEFAULT 0,
    is_delivered TINYINT(1) DEFAULT 0,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_id VARCHAR(255),
    payment_receipt_url VARCHAR(255),
    delivered_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_shipping_address (
    order_shipping_id VARCHAR(255) NOT NULL,
    order_id VARCHAR(255) NOT NULL,
    address_line1 VARCHAR(255) NOT NULL,
    address_line2 VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    phone VARCHAR(255),
    postal_code VARCHAR(255),
    state VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_billing_address (
    order_billing_id VARCHAR(255) NOT NULL,
    order_id VARCHAR(255) NOT NULL,
    address_line1 VARCHAR(255) NOT NULL,
    address_line2 VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    phone VARCHAR(255),
    postal_code VARCHAR(255),
    state VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_item (
    order_item_id VARCHAR(255) NOT NULL,
    order_item_price DOUBLE NOT NULL,
    order_extended_price DOUBLE NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    order_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (order_item_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT ORDER_FK FOREIGN KEY (order_id) REFERENCES order_table (order_id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
