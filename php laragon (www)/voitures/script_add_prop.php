<!DOCTYPE html>
<?php
    // connexion à la base de données
    try {
        $db = new PDO('mysql:host=localhost;charset=utf8;dbname=voitures', 'root', 'root');
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $db->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_OBJ);
    }

    catch (Exception $e) {
        echo "Erreur !: " . $e->getMessage() . "<br>";
        die();
    }
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php

        class Proprietaire {

            private string $nom;
            private string $prenom;
            private string $adresse;
            private string $ville;
            private int $cp;
            
            public function __construct (string $n, string $pre, string $ad, string $v, int $c) {
                $this->nom=$n;
                $this->prenom=$pre;
                $this->adresse=$ad;
                $this->ville=$v;
                $this->cp=$c;
            }

            public function getAssoc () {
                $assoc = array(
                    ':nom' => $this->nom,
                    ":prenom" => $this->prenom,
                    ":adresse" => $this->adresse,
                    ':ville' => $this->ville,
                    ':cp' => $this->cp
                );
                return $assoc;
            }

        }
        
        $prop = new Proprietaire($_POST["nom"],$_POST["prenom"],$_POST["adresse"],$_POST["ville"],$_POST["cp"]);

        $requete = $db->prepare("INSERT INTO proprietaire
         (nom,prenom,adresse,ville,codepostal) VALUES 
         (:nom,:prenom,:adresse,:ville,:cp)");
        $requete->execute($prop->getAssoc());
        $requete->closeCursor();

    ?>
</body>
</html>