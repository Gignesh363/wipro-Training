CREATE TABLE product (
    product_code INT PRIMARY KEY,
    product_name VARCHAR(50),
    product_category VARCHAR(50),
    product_description VARCHAR(100),
    product_price DOUBLE
);

INSERT INTO product VALUES (1001, 'LEDTV', 'electronics', 'TV', 45000.0);
INSERT INTO product VALUES (1002, 'Fridge', 'electronics', 'Refrigerator', 30000.0);
INSERT INTO product VALUES (1003, 'Laptop', 'computers', 'Personal Computer', 60000.0);
