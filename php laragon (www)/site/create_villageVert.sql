-- DROP DATABASE village;
CREATE DATABASE village;
use village;

-- creation des tables

CREATE TABLE Client(
   id_cli INT AUTO_INCREMENT,
   nom_cli VARCHAR(50) ,
   prenom_cli VARCHAR(50) ,
   tel_cli VARCHAR(50) ,
   mail_cli VARCHAR(50) ,
   noRue_cli VARCHAR(50) ,
   ville_cli VARCHAR(50) ,
   cp_cli INT ,
   categorie_cli VARCHAR(50) ,
   PRIMARY KEY(id_cli)
);

CREATE TABLE Fournisseur(
   id_fourn INT AUTO_INCREMENT,
   nom_fourn VARCHAR(50) ,
   prenom_fourn VARCHAR(50) ,
   tel_fourn VARCHAR(50) ,
   mail_fourn VARCHAR(50) ,
   noRue_fourn VARCHAR(50) ,
   ville_fourn VARCHAR(50) ,
   cp_fourn VARCHAR(50) ,
   PRIMARY KEY(id_fourn)
);

CREATE TABLE Facturation(
   id_fact INT AUTO_INCREMENT,
   adr_fact VARCHAR(50) ,
   date_fact DATETIME,
   PRIMARY KEY(id_fact)
);

CREATE TABLE Rubrique(
   id_rub INT AUTO_INCREMENT,
   nom_rub VARCHAR(50) ,
   PRIMARY KEY(id_rub)
);

CREATE TABLE Sous_rubrique(
   id_srub INT AUTO_INCREMENT,
   nom_srub VARCHAR(50) ,
   id_rub INT NOT NULL,
   PRIMARY KEY(id_srub)
);

CREATE TABLE Produit(
   id_Produit INT AUTO_INCREMENT,
   nomCourt_prod VARCHAR(50) ,
   stock_prod INT ,
   prixu_prod DECIMAL(10,2) ,
   ref_prod VARCHAR(50) ,
   nomLong_prod VARCHAR(50) ,
   photo_prod VARCHAR(50) ,
   id_fourn INT NOT NULL,
   id_srub INT NOT NULL,
   PRIMARY KEY(id_Produit)
);

CREATE TABLE Livraison(
   id_liv INT AUTO_INCREMENT,
   adr_liv VARCHAR(50) ,
   date_liv DATETIME,
   id_fact INT NOT NULL,
   PRIMARY KEY(id_liv)
);

CREATE TABLE Commande(
   id_com INT AUTO_INCREMENT,
   date_com DATETIME,
   prixtot_com DECIMAL(10,2) DEFAULT 0,
   id_liv INT NOT NULL,
   id_cli INT NOT NULL,
   PRIMARY KEY(id_com)
);

CREATE TABLE Lignecommande(
   id_ligne INT AUTO_INCREMENT,
   qtepro_ligne INT,
   id_com INT NOT NULL,
   id_Produit INT NOT NULL,
   PRIMARY KEY(id_ligne)
);


-- Ajout des contraintes sur les clés étrangères

ALTER TABLE Sous_rubrique
	ADD
      FOREIGN KEY(id_rub) REFERENCES Rubrique(id_rub)
;

ALTER TABLE Produit
	ADD
      FOREIGN KEY(id_fourn) REFERENCES Fournisseur(id_fourn)
;

ALTER TABLE Produit
	ADD
      FOREIGN KEY(id_srub) REFERENCES Sous_rubrique(id_srub)
;

ALTER TABLE Livraison
	ADD
      FOREIGN KEY(id_fact) REFERENCES Facturation(id_fact)
;

ALTER TABLE Commande
	ADD
   FOREIGN KEY(id_liv) REFERENCES Livraison(id_liv)
;

ALTER TABLE Commande
	ADD
      FOREIGN KEY(id_cli) REFERENCES client(id_cli)
;

ALTER TABLE Lignecommande
	ADD
      FOREIGN KEY(id_com) REFERENCES Commande(id_com)
;

ALTER TABLE Lignecommande
	ADD
      FOREIGN KEY(id_Produit) REFERENCES Produit(id_Produit)
;


-- ajout des triggers

-- ajoute le prix de la ligne de commande au prix de la commande
delimiter //
create or replace trigger t_insert_ligne
after insert
on lignecommande
for each row
BEGIN
DECLARE prixu DECIMAL(10,2);
DECLARE toadd DECIMAL (10,2);
SET prixu = (SELECT distinct(prixu_prod) FROM lignecommande NATURAL JOIN produit WHERE produit.id_produit=new.id_produit);
SET toadd = NEW.qtepro_ligne*prixu;
UPDATE commande
SET prixtot_com = prixtot_com + toadd
WHERE commande.id_com = NEW.id_com;
END //
delimiter ;

-- retire le prix de la ligne de commande au prix de la commande
delimiter //
create or replace trigger t_delete_ligne
before delete
on lignecommande
for each row
BEGIN
DECLARE prixu DECIMAL(10,2);
DECLARE tosub DECIMAL (10,2);
SET prixu = (SELECT distinct(prixu_prod) FROM lignecommande NATURAL JOIN produit WHERE produit.id_produit=old.id_produit);
SET tosub = old.qtepro_ligne*prixu;
UPDATE commande
SET prixtot_com = prixtot_com - tosub
WHERE commande.id_com = old.id_com;
END //
delimiter ;

-- modifie le prix de la commande à la modification d'une ligne de commande et empeche la modification de l'id de commande ou produit de la ligne
delimiter //
create or replace trigger t_update_ligne
after update
on lignecommande
for each row
BEGIN
DECLARE prixu DECIMAL(10,2);
DECLARE ratio INT;
DECLARE tochange INT;
if (old.id_com <> new.id_com) then
SIGNAL SQLSTATE '40000' SET message_text = 'interdiction d''update une ligne de commande sur une autre commande';
END IF;
if (old.id_produit <> new.id_produit) then
SIGNAL SQLSTATE '40000' SET message_text = 'interdiction d''update le produit lié à la ligne de commande';
END IF;
SET prixu = (SELECT distinct(prixu_prod) FROM lignecommande NATURAL JOIN produit WHERE produit.id_produit=old.id_produit);
SET ratio  = NEW.qtepro_ligne - OLD.qtepro_ligne;
SET tochange = ratio*prixu;
UPDATE commande
SET prixtot_com = prixtot_com + tochange
WHERE commande.id_com = old.id_com;
END //
delimiter ;


-- insertion des données

INSERT INTO Client (id_cli,nom_cli,prenom_cli,tel_cli,mail_cli,noRue_cli,ville_cli,cp_cli,categorie_cli)
VALUES
(1,'Coupart','pascal','0662384363','coupartpascal@gg.fr','66','Tetry','80200','particulier'),
(2,'Gareau','jean','0631236202','jeangareau@aa.fr','86','Pagolle','64120','particulier'),
(3,'Beachamp','colette','0639185491','colettebeauchamp@ff.fr','73','Echalot','21510','professionel'),
(4,'Grenier','jacques','0669622339','jacquesgrenier@vv.fr','32','Toulouzette','40250','particulier'),
(5,'Vertefeuille','juliette','0652367050','juliettevertefeuille@dd.fr','88','Valdoule','05150','professionel');


INSERT INTO Fournisseur(id_fourn,nom_fourn,prenom_fourn,tel_fourn,mail_fourn,noRue_fourn,ville_fourn,cp_fourn)
VALUES
(100,'Paquette','susanne','0672057857','susannepaquette@ee.fr','55','Radinghem-en-Weppes','59320'),
(101,'Rochon','victorine','0620387174','victorinerochon@jj.fr','49','Tronchy','71440'),
(102,'Villeneuve','geoffrey','0697483340','geoffreyvilleneuve@nn.fr','20','Aucun','65400'),
(103,'Charpie','madeleine','0614702535','madeleinecharpie@cc.fr','48','Pettoncourt','57170'),
(104,'Paiement','franck','06649375436','franckpaiement@qq.fr','56','Vaulx','62390');


INSERT INTO Facturation(id_fact,adr_fact,date_fact)
VALUES
(200,'86 Voie des Marronniers, Pagolle','2021-12-26 00:00:00'),
(201,'73 Boulevard des Cultivateurs, Echalot','2021-04-29 00:00:00'),
(202,'86 Voie des Marronniers, Pagolle','2021-02-27 00:00:00'),
(203,'32 Chemin du Saule, Toulouzette','2021-05-10 00:00:00'),
(204,'73 Boulevard des Cultivateurs, Echalot','2021-10-31 00:00:00'),
(205,'73 Boulevard des Cultivateurs, Echalot','2021-07-08 00:00:00'),
(206,'32 Chemin du Saule, Toulouzette','2021-04-15 00:00:00'),
(207,'86 Voie des Marronniers, Pagolle','2021-12-18 00:00:00'),
(208,'73 Boulevard des Cultivateurs, Echalot','2021-07-14 00:00:00'),
(209,'73 Boulevard des Cultivateurs, Echalot','2021-01-05 00:00:00');


INSERT INTO Rubrique(id_Rub,nom_rub)
VALUES
(400,'instrument à corde'),
(401,'percussion'),
(402,'jouets');


INSERT INTO Sous_rubrique(id_srub,nom_srub,id_rub)
VALUES
(300,'guitare',400),
(301,'banjo',400),
(302,'violon',400),
(303,'tambour',401),
(304,'cymbale',401),
(305,'kazoo',402),
(306,'guimbarde',402);


-- FOREIGN KEY(id_fourn) REFERENCES Fournisseur(id_fourn)
-- FOREIGN KEY(id_rub) REFERENCES Rubrique(id_rub)
INSERT INTO Produit(id_Produit,nomCourt_prod,stock_prod,prixu_prod,ref_prod,nomLong_prod,photo_prod,id_fourn,id_srub)
VALUES
(500,'guitare PX130',20,120,'GTRPX130','guitare de qualité moyenne','photo',100,300),
(501,'guitare FF150',35,100,'GTRFF150','guitare novice','photo',103,300),
(502,'guitare YH520',20,600,'GTRYH520','guitare professionelle','photo',100,300),
(503,'banjo KZ010',10,320,'BJOKZ010','banjo KZ est un banjo plutot ok','photo',102,301),
(504,'violon ET020',30,650,'VIOET020','violon d''entrainement','photo',101,302),
(505,'violon PR540',22,1700,'VIOPR540','violon semi-pro','photo',104,302),
(506,'tambour TT100',25,150,'TAMTT100','tambour simple','photo',101,303),
(507,'cymbale GG001',17,300,'CYMBGG001','reference en matière de cymbale','photo',101,304),
(508,'kazoo MT000',50,5,'KAZMT000','kazoo en metal','photo',103,305),
(509,'kazoo PT001',95,3,'KAZPT600','kazoo en plastique','photo',103,305),
(510,'guimbarde GG88',80,3,'GMBGG888','guimbarde metallique','photo',103,306);


-- FOREIGN KEY(id_fact) REFERENCES Facturation(id_fact)
INSERT INTO Livraison(id_liv,adr_liv,date_liv,id_fact)
VALUES
(600,'86 Voie des Marronniers, Pagolle','2022-01-02 00:00:00',200),
(601,'73 Boulevard des Cultivateurs, Echalot','2021-05-05 00:00:00',201),
(602,'86 Voie des Marronniers, Pagolle','2021-03-07 00:00:00',202),
(603,'32 Chemin du Saule, Toulouzette','2021-05-17 00:00:00',203),
(604,'73 Boulevard des Cultivateurs, Echalot','2021-11-08 00:00:00',204),
(605,'73 Boulevard des Cultivateurs, Echalot','2021-07-17 00:00:00',205),
(606,'32 Chemin du Saule, Toulouzette','2021-04-21 00:00:00',206),
(607,'86 Voie des Marronniers, Pagolle','2021-12-25 00:00:00',207),
(608,'73 Boulevard des Cultivateurs, Echalot','2021-07-20 00:00:00',208),
(609,'73 Boulevard des Cultivateurs, Echalot','2021-01-10 00:00:00',209);


-- FOREIGN KEY(id_liv) REFERENCES Livraison(id_liv)
-- FOREIGN KEY(id_cli) REFERENCES client(id_cli)
INSERT INTO Commande(id_com,date_com,prixtot_com,id_liv,id_cli)
VALUES
(700,'2021-12-26 00:00:00',0,600,2),
(701,'2021-04-29 00:00:00',0,601,3),
(702,'2021-02-27 00:00:00',0,602,2),
(703,'2021-05-10 00:00:00',0,603,4),
(704,'2021-10-31 00:00:00',0,604,3),
(705,'2021-07-08 00:00:00',0,605,3),
(706,'2021-04-15 00:00:00',0,606,4),
(707,'2021-12-18 00:00:00',0,607,2),
(708,'2021-07-14 00:00:00',0,608,3),
(709,'2021-01-05 00:00:00',0,609,3);


-- FOREIGN KEY(id_com) REFERENCES Commande(id_com),
-- FOREIGN KEY(id_Produit) REFERENCES Produit(id_Produit)
INSERT INTO Lignecommande(id_ligne,qtepro_ligne,id_com,id_Produit)
VALUES
(800,2,700,503),
(801,6,700,507),
(802,9,701,502),
(803,5,701,509),
(804,6,702,501),
(805,6,703,507),
(806,6,703,508),
(807,9,703,503),
(808,8,703,505),
(809,5,704,500),
(810,5,704,506),
(811,3,704,502),
(812,0,705,503),
(813,3,706,500),
(814,4,706,504),
(815,4,706,502),
(816,2,706,505),
(817,5,706,504),
(818,1,706,501),
(819,8,707,501),
(820,7,707,506),
(821,1,707,507),
(822,3,708,504),
(823,1,708,506),
(824,4,709,509);