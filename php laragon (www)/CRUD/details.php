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
    <title>Details</title>
    <link rel="stylesheet" href="styles/details.css">
</head>
<body>

    <?php
        $id=$_GET["disc_id"];
        $requete = $db->prepare("SELECT * FROM disc natural join artist WHERE disc_id=?");
        $requete->execute(array($id));
        $info = $requete->fetch();
        $requete->closeCursor();
    ?>

    <h2>Details</h2>
    <div class="line"></div>

    <div id="tableau">

        <div class="cadre" id="title">
            <div class="infos">Titre</div>
            <div class="donnees"><?= $info->disc_title ?></div>
        </div>

        <div class="cadre" id="artist">
            <div class="infos">Artist</div>
            <div class="donnees"><?= $info->artist_name ?></div>
        </div>

        <div class="cadre" id="year">
            <div class="infos">Year</div>
            <div class="donnees"><?= $info->disc_year ?></div>
        </div>

        <div class="cadre" id="genre">
            <div class="infos">Genre</div>
            <div class="donnees"><?= $info->disc_genre ?></div>
        </div>

        <div class="cadre" id="label">
            <div class="infos">Label</div>
            <div class="donnees"><?= $info->disc_label ?></div>
        </div>

        <div class="cadre" id="price">
            <div class="infos">Price</div>
            <div class="donnees"><?= $info->disc_price." €" ?></div>
        </div>

    </div>

    <p id="capt">Cover</p>
    
    <?php $name=$info->disc_picture ?>
    <img id="picture" src="pictures/<?= $name?>" alt="<?= $name ?>">

    <!-- formulaires de modification, suppression et retour -->
    <div id="formulaires">
     
    <form action="update_form.php" method="get">
        <input type="hidden" name="disc_id" value="<?= $id ?>">
        <input class="orange btn" type="submit" value="Modifier">
    </form>
 
    <form action="delete_script.php" method="get">
        <input type="hidden" name="disc_id" value="<?= $id ?>">
        <input class="red btn" type="submit" value="Suprimer">
    </form>

    <form action="index.php">
        <input class="blue btn" type="submit" value="Retour">
    </form>
    
    </div>
    
</body>
</html>