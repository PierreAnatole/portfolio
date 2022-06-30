<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Valeurs</title>
</head>
<body>
    <h1>informations données :</h1>

    <?php

        echo "Nom et prénom : ".$_POST["nomPrenom"]."<br>";
        echo "CIN : ".$_POST["cin"]."<br>";
        echo "Adresse e-mail : ".$_POST["mail"]."<br>";

        echo "Niveau : ".$_POST["niveau"]."<br>";
        echo "Modules et formations : ";
        
        if (isset($_POST["modules"])) { 
            $modules = $_POST["modules"];

            foreach ($modules as $i => $m) {
                echo $m;
                if (($i+1)!=count($modules)){
                    echo "/";
                }
            }
            
        }

    ?>

</body>
</html>