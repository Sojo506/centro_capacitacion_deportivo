CREATE DATABASE IF NOT EXISTS centro_capacitacion_deportivo;

USE centro_capacitacion_deportivo;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(64) NOT NULL,
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
    athlete_id INT NOT NULL,
    active TINYINT(1) DEFAULT 1,
    FOREIGN KEY (athlete_id) REFERENCES athletes(id)
);

CREATE TABLE sports (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    characteristics TEXT,
    active TINYINT(1) DEFAULT 1
);

CREATE TABLE routines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    sport_id INT NOT NULL,
    duration_minutes INT,
    active TINYINT(1) DEFAULT 1,
    FOREIGN KEY (sport_id) REFERENCES sports(id)
);

CREATE TABLE invoices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME DEFAULT CURRENT_TIMESTAMP,
    athlete_id INT NOT NULL,
    total_amount DECIMAL(10,2),
    active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (athlete_id) REFERENCES athletes(id)
);

CREATE TABLE invoice_routine (
    invoice_id INT NOT NULL,
    routine_id INT NOT NULL,
    PRIMARY KEY (invoice_id, routine_id),
    FOREIGN KEY (invoice_id) REFERENCES invoices(id),
    FOREIGN KEY (routine_id) REFERENCES routines(id)
);
