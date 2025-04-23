CREATE DATABASE travel_db;

USE travel_db;

CREATE TABLE packages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    destination VARCHAR(100),
    price VARCHAR(50),
    days VARCHAR(20),
    transport VARCHAR(50),
    hotel VARCHAR(100)
);