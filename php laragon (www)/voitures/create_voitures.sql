DROP DATABASE voitures;
CREATE DATABASE voitures;
USE voitures;

CREATE TABLE proprietaire(
   id_pers INT AUTO_INCREMENT,
   nom VARCHAR(30)  NOT NULL,
   prenom VARCHAR(30) ,
   adresse VARCHAR(50)  NOT NULL,
   ville VARCHAR(40)  NOT NULL,
   codepostal INT NOT NULL,
   PRIMARY KEY(id_pers)
);

CREATE TABLE modele(
   id_modele VARCHAR(10) ,
   modele VARCHAR(30) ,
   carburant VARCHAR(20) ,
   PRIMARY KEY(id_modele)
);

CREATE TABLE voiture(
   immat VARCHAR(6) ,
   id_modele VARCHAR(10)  NOT NULL,
   couleur VARCHAR(10)  NOT NULL,
   datevoiture VARCHAR(50)  NOT NULL,
   PRIMARY KEY(immat)
);

CREATE TABLE cartegrise(
   id_pers INT AUTO_INCREMENT,
   immat VARCHAR(6) ,
   datecarte VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_pers, immat)
);

ALTER TABLE voiture ADD
    FOREIGN KEY(id_modele) REFERENCES modele(id_modele);

ALTER TABLE cartegrise ADD
    FOREIGN KEY(immat) REFERENCES voiture(immat);

ALTER TABLE cartegrise ADD
    FOREIGN KEY(id_pers) REFERENCES proprietaire(id_pers);

INSERT INTO modele (id_modele,modele,carburant) 
VALUES 
('563339GH56','Citroën C3','essence'),
('17C92853AZ','Citroën C3','essence'),
('178524ER45','Citroën Picasso','essence'),
('ZER627864K','Ferrari GT 40','essence'),
('33356677PO','Peugeot 206','essence'),
('AZER67455T','Citroën 307','essence'),
('DSQS455674','Renault Adventime','essence'),
('B3321TY455','Renault Espace','essence'),
('QSDFGH7777','Renault Modus','essence'),
('7499RF5679','Renault Mégane Scénic','essence'),
('FHT55432GH','Renault Twingo','essence'),
('485228FGD7','Volkswagen Golf','essence');