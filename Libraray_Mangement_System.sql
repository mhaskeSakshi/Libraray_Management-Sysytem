CREATE DATABASE Libraray_Mangement_System;

USE Libraray_Mangement_System;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    year INT
);
