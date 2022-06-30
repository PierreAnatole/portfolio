<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/q_village.css">
    <link rel="stylesheet" href="styles/categorie.css">
    <title>Instruments à corde</title>
</head>
<body>
    <div id="page">
        <?php require_once 'header.php' ;?>

        <?php

        // l'id de la rubrique "instrument a corde" correspond à 400
        const ID_INSTRUMENT_A_CORDE = 400;

        require_once 'affiche-ssrub.php';
        $sous_rub = ssrub(ID_INSTRUMENT_A_CORDE);

        foreach ($sous_rub as $sr) {
            echo($sr->nom_srub)."<br>";
        }
    
        ?>

        

    </div>
</body>
</html>