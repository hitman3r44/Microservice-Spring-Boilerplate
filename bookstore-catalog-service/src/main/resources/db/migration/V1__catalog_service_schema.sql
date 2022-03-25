create table product (
    product_id varchar(255) not null,
    available_item_count integer not null,
    product_description varchar(255),
    price double not null,
    product_name varchar(255) not null,
    product_category_id varchar(255),
    product_image_id varchar(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key (product_id)
);

create table product_category (
    product_category_id varchar(255) not null,
    description varchar(255),
    product_category_name varchar(255) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key (product_category_id)
);

alter table product
    add constraint FKProductToProductCategory
    foreign key (product_category_id)
    references product_category(product_category_id);

create table review (
    review_id varchar(255) not null,
    user_id varchar(255),
    rating_value double not null,
    review_message varchar(1000),
    product_id varchar(255) not null,
    user_name varchar(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key (review_id)
);