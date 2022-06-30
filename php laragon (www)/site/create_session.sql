DROP DATABASE sessionvg;
CREATE DATABASE sessionvg;
use sessionvg;

CREATE TABLE user (
    id_user INT AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_user)
);

CREATE TABLE session (
    id_session INT AUTO_INCREMENT,
    id_user INT NOT NULL,
    PRIMARY KEY(id_session)
);