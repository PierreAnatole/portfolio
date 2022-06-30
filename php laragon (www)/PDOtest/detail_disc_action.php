<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultat detail disc</title>
</head>
<body>
    
    <?php

        $db = new PDO('mysql:host=localhost;charset=utf8;dbname=record', 'root', 'root');
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        
        $requete = $db->prepare("SELECT * from disc where disc_id=?");
        $requete->execute(array($_POST["disc_id"]));
        $disc = $requete->fetch(PDO::FETCH_OBJ);
        if (isset($disc->disc_id)) {
            echo "<div>Disc N° ",$disc->disc_id,"<br>";
            echo "Disc name : ",$disc->disc_title,"<br>";
            echo "Disc year : ",$disc->disc_year,"</div>";
        }
        else {
            echo "id de disque n'existe pas";
        }
        
    ?>

</body>
</html>