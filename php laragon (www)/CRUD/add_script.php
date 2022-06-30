<!DOCTYPE html>
<?php
    // connexion à la base de données
    try {
        $db = new PDO('mysql:host=localhost;charset=utf8;dbname=record', 'root', 'root');
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
    <title>script d'envoi</title>
    <link rel="stylesheet" href="styles/add_form.css">
</head>
<body>

    <?php

        // nom du fichier (sans path et avec extension).
        $imgName = basename($_FILES["picture"]["name"]);

        // nom de l'espace ou chercher l'image.
        $tmp_name = $_FILES["picture"]["tmp_name"];

        // deplacement du fichier dans le repertoire pictures, en gardant son nom d'origine.
        move_uploaded_file($tmp_name, "pictures/$imgName");

        $assoc = array(
            ':title' => $_POST["title"],
            ":year" => $_POST["year"],
            ":picture" => $imgName,
            ':label' => $_POST["label"],
            ':genre' => $_POST["genre"],
            ":price" => $_POST["price"],
            ":aid" => $_POST["artist"]
        );

        $requete = $db->prepare("INSERT INTO disc 
        (disc_title,disc_year,disc_picture,disc_label,disc_genre,disc_price,artist_id) VALUES 
        (:title,:year,:picture,:label,:genre,:price,:aid)");
        $requete->execute($assoc);
        $requete->closeCursor();

        // redirection
        header("location: index.php");
    ?>

</body>
</html>