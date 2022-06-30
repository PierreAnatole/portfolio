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
    <title>Index</title>
    <link rel="stylesheet" href="styles/index.css">
</head>

<body>

    
    <?php
        // requête de récupération des disques (jointure avec artist pour récupérer le nom de l'artiste)
        $requete = $db->query("SELECT * FROM disc natural join artist");
        $disques = $requete->fetchall();
        $requete->closeCursor();
    ?>

    
    <h1>Liste des disques (<?= count($disques)?>)</h1>

    <!-- bouton d'ajout -->
    <form action="add_form.php" method="get" id="ajout">
        <input class="green btn" type="submit" value="Ajouter">
    </form>

    <div id="disques">
        <?php $path="pictures/"; ?>
        <!-- insertion des disques à la page -->
        <?php foreach ($disques as $d):?>
            <div class=disque>
                <img src="<?= $path.$d->disc_picture ?>" alt="<?= $d->disc_picture?>">
                <div class="infos">
                    <div class="infos_text">
                        <span class="bold"> <?=$d->disc_title?> </span>
                        <span class="bold"> <?=$d->artist_name?> </span>
                        <span><span class="bold">Label : </span> <?=$d->disc_label?> </span>
                        <span><span class="bold">Year : </span> <?=$d->disc_year?> </span>
                        <span><span class="bold">Genre : </span> <?=$d->disc_genre?> </span>
                    </div>
                    <div class="formulaires">
                        <form action="details.php" method="get">
                            <input type="hidden" name="disc_id" value="<?=$d->disc_id?>">
                            <input class="blue btn" type="submit" value="Details">
                        </form>
                        <form action="delete_script.php" method="get">
                            <input type="hidden" name="disc_id" value="<?=$d->disc_id?>">
                            <input class="red btn" type="submit" value="supprimer">
                        </form>
                    </div>
                </div>       
            </div>
        <?php endforeach ?>
    </div>

    
</body>

</html>