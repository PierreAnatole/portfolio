<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>action</title>
</head>
<body>
    <?php

        // nom du fichier (sans path et avec extension).
        $name = basename($_FILES["fichier"]["name"]);

        // nom de l'espace ou chercher l'image.
        $tmp_name = $_FILES["fichier"]["tmp_name"];

        // deplacement du fichier dans le repertoire telecharges, en gardant son nom d'origine.
        move_uploaded_file($tmp_name, "telecharges/$name");

        // affichage
        echo "<img src=\"telecharges/$name\" alt=\"aa\">";
    ?>
</body>
</html>