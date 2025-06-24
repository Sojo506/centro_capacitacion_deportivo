CREATE DATABASE IF NOT EXISTS centro_capacitacion_deportivo;

USE centro_capacitacion_deportivo;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    nickname VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(64) NOT NULL,
    active TINYINT(1) DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE athletes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    city VARCHAR(100),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100),
    active TINYINT(1) DEFAULT 1
);