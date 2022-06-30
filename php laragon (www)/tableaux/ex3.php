<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex3</title>
</head>
<body>
    <?php
    $departements = array(
        "Hauts-de-france" => array("Aisne", "Nord", "Oise", "Pas-de-Calais", "Somme"),
        "Bretagne" => array("Côtes d'Armor", "Finistère", "Ille-et-Vilaine","Morbihan"),
        "Grand-Est" => array("Ardennes", "Aube", "Marne", "Haute-Marne", "Meurthe-etMoselle", "Meuse", "Moselle", "Bas-Rhin", "Haut-Rhin", "Vosges"),
        "Normandie" => array("Calvados", "Eure", "Manche", "Orne", "Seine-Maritime")
       );
       
       echo "<h2>région suivi du nom des departements :</h2><br>";
       foreach($departements as $reg => $dep) {
           echo "<h4>".$reg."</h4>";
           foreach($dep as $nom){
               echo $nom."<br>";
           }
       }

       echo "<h2>région suivi du nombre de departements :</h2><br>";
       foreach($departements as $reg => $dep) {
        echo $reg." : nombre de departements : ".count($dep)."<br>";
    }

    ?>
</body>
</html>