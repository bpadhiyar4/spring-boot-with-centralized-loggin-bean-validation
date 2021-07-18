DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;

CREATE TABLE users
(
    id INT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL
);

CREATE TABLE products
(
    id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL
);

CREATE TABLE orders
(
    id INT NOT NULL PRIMARY KEY,
    user_id INT,
    product_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO users VALUES(1,'Bharat');

INSERT INTO products VALUES(1, 'Laptop');
INSERT INTO products VALUES(2, 'Keyboard');
INSERT INTO products VALUES(3, 'Mouse');
INSERT INTO products VALUES(4, 'Computer');