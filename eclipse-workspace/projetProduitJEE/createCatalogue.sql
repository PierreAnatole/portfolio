DROP DATABASE catalogue;
CREATE DATABASE catalogue;
USE catalogue;

CREATE TABLE produit(
   id INT AUTO_INCREMENT,
   designation VARCHAR(50),
   prix INT,
   quantite INT,
   PRIMARY KEY(id)
);

-- insertion des donnees 

INSERT INTO produit(designation,prix,quantite) VALUES
('yaourt',150,50),
('lait',250,50),
('poivron',350,50),
('pomme',100,50),
('cassoulet',120,50),
('sucre',380,50),
('farine',200,50),
('steak',550,50),
('poisson',850,50),
('oeuf',50,50);