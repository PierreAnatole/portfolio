<!DOCTYPE html>
<?php
    // connexion à la base de données
    try {
        $db = new PDO('mysql:host=localhost;charset=utf8;dbname=voitures', 'root', 'root');
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
    <title>Affiche modeles</title>
</head>
<body>

    <?php
        $requete = $db->query("SELECT * FROM modele ORDER BY modele");
        $mod = $requete->fetchall();
        $requete->closeCursor();
    ?>

    <table>
        <tr>
            <td>Type</td>
            <td>Modele</td>
        </tr>
        <?php foreach($mod as $v): ?>
            <tr>
                <td><?= $v->id_modele ?></td>
                <td><?= $v->modele ?></td>
            </tr>
        <?php endforeach ;?>
    </table>
</body>
</html>