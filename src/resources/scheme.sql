CREATE DATABASE IF NOT EXISTS centro_capacitacion_deportivo;

USE centro_capacitacion_deportivo;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(64) NOT NULL,
    active TINYINT(1) DEFAULT 1
);

CREATE TABLE parents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    city VARCHAR(100),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100) NOT NULL UNIQUE,
    active TINYINT(1) DEFAULT 1
);

CREATE TABLE athletes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    city VARCHAR(100),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100) NOT NULL UNIQUE,
    parent_id INT NULL,
    active TINYINT(1) DEFAULT 1,
    FOREIGN KEY (parent_id) REFERENCES parents(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE routines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    duration_minutes INT,
    active TINYINT(1) DEFAULT 1
);

CREATE TABLE sports (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    characteristics TEXT,
    active TINYINT(1) DEFAULT 1
);

CREATE TABLE routine_sports (
    id INT AUTO_INCREMENT PRIMARY KEY,
    routine_id INT NOT NULL,
    sport_id INT NOT NULL,
    FOREIGN KEY (routine_id) REFERENCES routines(id) ON DELETE CASCADE,
    FOREIGN KEY (sport_id) REFERENCES sports(id)
);

CREATE TABLE invoices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    parent_id INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    status ENUM('PENDING', 'PAID') DEFAULT 'PENDING',
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (parent_id) REFERENCES parents(id)
        ON DELETE RESTRICT
);

CREATE TABLE invoice_routines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT NOT NULL,
    routine_id INT NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoices(id) ON DELETE CASCADE,
    FOREIGN KEY (routine_id) REFERENCES routines(id)
);

