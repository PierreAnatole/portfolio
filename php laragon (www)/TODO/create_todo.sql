DROP DATABASE todo;
CREATE DATABASE todo;
USE todo; 

CREATE TABLE list (
    id_todo INT AUTO_INCREMENT,
    name VARCHAR(100),
    done BIT,
    PRIMARY KEY(id_todo)
);