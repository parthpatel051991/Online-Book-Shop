DROP DATABASE IF EXISTS BookShop;
CREATE DATABASE BookShop;
USE BookShop;

CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_email varchar(20),
    user_password varchar(20),
    user_first_name varchar(20),
    user_last_name varchar(20)
);

INSERT INTO users (user_email,user_password,user_first_name,user_last_name)
values ("test1@gmail.com","abcxyz","test1","test1"),
	   ("test2@gmail.com","abcxyz","test2","test2"),
       ("test3@gmail.com","abcxyz","test3","test3");

#select * from users;

CREATE TABLE books(
	book_id INT PRIMARY KEY AUTO_INCREMENT,
    book_name varchar(30),
    author_name varchar(30),
    user_id INT,
    FOREIGN KEY(user_id) REFERENCES users (user_id)
);

INSERT INTO books(book_name,author_name,user_id) 
values	("Aleph","Paulo Coelho",1),
		("Alchemist","Paulo Coelho",1),
        ("Wings of Fire","Arun Tiwari",2),
        ("Becoming","Michelle Obama",3),
        ("Immortals of Meluha","Amit Tripathi",3);

#select * from books;
