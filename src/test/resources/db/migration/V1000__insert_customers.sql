-- TODO WHY IS THIS NOT LOADING???
INSERT INTO customers (id, first_name, middle_name, last_name, email_address, phone_number)
VALUES (RANDOM_UUID(), 'John', NULL, 'Smith', 'john.smith@email.com', '+1-555-123-4567'),
       (RANDOM_UUID(), 'Maria', 'Rose', 'Garcia', 'maria.garcia@email.com', '+1-555-234-5678'),
       (RANDOM_UUID(), 'James', NULL, 'Wilson', 'james.wilson@email.com', '+1-555-345-6789');