CREATE DATABASE libirary;

USE libirary;

CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
password VARCHAR(255) NOT NULL,
role ENUM('User', 'Admin') NOT NULL
);
-- ALTER TABLE books ADD(author TEXT);
-- ALTER TABLE books CHANGE COLUMN auther author VARCHAR (255);

CREATE TABLE books (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255) NOT NULL,
author VARCHAR(255) NOT NULL,
available BOOLEAN DEFAULT TRUE
);

CREATE TABLE loans (
id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(100) NOT NULL,
book_id INT NOT NULL,
loan_date DATE DEFAULT (CURRENT_DATE),
return_date DATE NULL, 
FOREIGN KEY (book_id) REFEReNCES books(id)ON DELETE CASCADE
);


-- Insert users
INSERT INTO users (name, password, role) VALUES 
('admin','admin123','admin'),
('user1','password1','User'),
('user2','password2','User');

-- Insert books
INSERT INTO books (title, author, available) VALUES
('1984', 'George Orwell', TRUE),
('Brave New World', 'Aldous Huxley', TRUE),
('To Kill a Mockingbird', 'Harper Lee', TRUE); 

 -- Select *
 SELECT * FROM users;
 SELECT * FROM books;
 SELECT * FROM loans;



