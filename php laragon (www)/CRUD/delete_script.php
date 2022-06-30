<!DOCTYPE html>
<?php
    // connexion à la base de données
    try {
        $db = new PDO('mysql:host=localhost;charset=utf8;dbname=record', 'root', 'root');
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
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
    <title>formulaire de suppression</title>
</head>
<body>

    <?php 
        $id=$_GET["disc_id"];

        $requete = $db->prepare("DELETE FROM disc WHERE disc_id=?");
        $requete->execute(array($id));
        $requete->closeCursor();

        // redirection
        header("location: index.php");
    ?>
</body>
</html>