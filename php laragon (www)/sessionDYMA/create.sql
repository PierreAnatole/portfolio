DROP DATABASE test;
CREATE DATABASE test;
use test;



create table user(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

create table session(
    id INT NOT NULL AUTO_INCREMENT,
    userid INT NOT NULL,
    PRIMARY KEY(id)
);