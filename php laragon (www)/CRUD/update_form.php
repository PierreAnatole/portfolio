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
    <title>Update</title>
    <link rel="stylesheet" href="styles/update_form.css">
    <script src=scripts/update_form.js></script>
</head>
<body>

    <?php
        // recherche des noms d'artiste pour les ajouter dans la liste déroulante
        $requete = $db->query("SELECT * FROM artist");
        $artistes = $requete->fetchall();
        $requete->closeCursor();
    ?>

    <?php
        // id du disque concerné par la modification
        $id=$_GET["disc_id"];
        $requete2 = $db->prepare("SELECT * FROM disc natural join artist WHERE disc_id=?");
        $requete2->execute(array($id));
        $info = $requete2->fetch();
        $requete2->closeCursor();
    ?>

    <h1>Formulaire de modification</h1>
    <div class="line"></div>

    <h2>modifier un vinyle</h2>

    <!-- les value sont instanciée à leur valeurs d'origine -->
    <form action="update_script.php" method="post" id="form" enctype="multipart/form-data">
        <label for="title">Title</label>
        <input type="text" name="title" id="title" value="<?= $info->disc_title?>">

        <label for="artist">Artist</label>
        <select name="artist" id="artist">

        <?php foreach ($artistes as $a): ?>
            <option value="<?= $a->artist_id ?>"
            <?php if ($a->artist_id==$info->artist_id): ?>
                selected="selected"
            <?php endif ?>
            > <?=$a->artist_name?> </option>;
        <?php endforeach ?>
        
        </select>

        <label for="year">Year</label>
        <input type="text" name="year" id="year" value=<?= "\"".$info->disc_year."\""?>>

        <label for="genre">Genre</label>
        <input type="text" name="genre" id="genre" value=<?= "\"".$info->disc_genre."\""?>>

        <label for="label">Label</label>
        <input type="text" name="label" id="label" value=<?= "\"".$info->disc_label."\""?>>

        <label for="price">Price</label>
        <input type="text" name="price" id="price" value=<?= "\"".$info->disc_price."\""?>>

        <label for="picture">Picture : </label>
        <input type="file" name="picture" id="picture">

        <input type="hidden" name="disc_id" value=<?= $id?>>
        <!-- sauvegarde le nom de l'ancienne image en cas de non modification -->
        <input type="hidden" name="last-picture" id="last-picture" value="<?= $info->disc_picture?>">
        
        <p>ancien fichier : <?= $info->disc_picture?></p>
        <img src="pictures/<?= $info->disc_picture ?>" alt="pictures/<?= $info->disc_picture?>" id="preview">

        
    </form>
    
    <div id="boutons">
    <form action="index.php" >
        <input class="blue btn" type="submit" value="Retour">
    </form>
    <input form="form" class="orange btn" type="submit" value="Modifier">
    </div>
    
    
</body>
</html>