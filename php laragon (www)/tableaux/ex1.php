<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex1</title>
    <link rel="stylesheet" href="styles/ex1.css">
</head>
<body>
    <?php
    $mois = array (
        "janvier" => 31,
        "février" => 28,
        "mars" => 31,
        "avril" => 30,
        "mai" => 31,
        "juin" => 30,
        "juillet" => 31,
        "aout" => 31,
        "septembre" => 30,
        "octobre" => 31,
        "novembre" => 30,
        "decembre" => 31
    );

    echo "table trié par ordre d'ajout : ";

    echo "<table>";
    foreach($mois as $nom => $jours) {
        echo "<tr><td>$nom</td><td>$jours</td></tr>";
    }
    echo "</table>";

    asort($mois);

    echo "table trié par nombre de jours : ";
    echo "<table>";
    foreach($mois as $nom => $jours) {
        echo "<tr><td>$nom</td><td>$jours</td></tr>";
    }
    echo "</table>";

    ?>
</body>
</html>