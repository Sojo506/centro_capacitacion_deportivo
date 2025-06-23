CREATE DATABASE IF NOT EXISTS centro_capacitacion_deportivo;

USE centro_capacitacion_deportivo;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100),
    nickname VARCHAR(50) UNIQUE,
    password_hash VARCHAR(64),
    active BOOLEAN
);