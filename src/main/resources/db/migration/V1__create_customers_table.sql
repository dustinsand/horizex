CREATE TABLE customers
(
    id            UUID PRIMARY KEY,
    first_name    VARCHAR(255) NOT NULL,
    middle_name   VARCHAR(255),
    last_name     VARCHAR(255) NOT NULL,
    email_address VARCHAR(255) NOT NULL UNIQUE,
    phone_number  VARCHAR(255) NOT NULL
);
