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
    <title>Formulaire d'ajout</title>
    <link rel="stylesheet" href="styles/add_form.css">
    <script src=scripts/add_form.js></script>
</head>
<body>

    <?php
        // recherche des noms d'artiste pour les ajouter dans la liste déroulante
        $requete = $db->query("SELECT * FROM artist");
        $artistes = $requete->fetchall();
        $requete->closeCursor();
    ?>

    <h1>Le formulaire d'ajout</h1>
    <div class="line"></div>

    <h2>Ajouter un vinyle</h2>

    <form action="add_script.php" method="post" id="form" enctype="multipart/form-data">
        <label for="title">Title</label>
        <input type="text" name="title" id="title">

        <label for="artist">Artist</label>
        <select name="artist" id="artist">
        <?php foreach ($artistes as $a): ?>
            <option value="<?=$a->artist_id?>"> <?=$a->artist_name?> </option>
        <?php endforeach; ?>
        </select>

        <label for="year">Year</label>
        <input type="text" name="year" id="year">

        <label for="genre">Genre</label>
        <input type="text" name="genre" id="genre">

        <label for="label">Label</label>
        <input type="text" name="label" id="label">

        <label for="price">Price</label>
        <input type="text" name="price" id="price">

        <label for="picture">Picture : </label>
        <input type="file" name="picture" id="picture">

    </form>
    
    <div id="boutons">
    <form action="index.php" >
        <input class="blue btn" type="submit" value="Retour">
    </form>
    <input form="form" class="green btn" type="submit" value="Ajouter">
    </div>
    

</body>
</html>