<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ajout proprietaire</title>
    <script src="scripts/form_prop.js"></script>
</head>
<body>
    <form action="script_add_prop.php" method="post" id="form">
        <label for="nom">Nom</label>
        <input type="text" name="nom" id="nom"><br>

        <label for="prenom">Prenom</label>
        <input type="text" name="prenom" id="prenom"><br>

        <label for="adresse">Adresse</label>
        <input type="text" name="adresse" id="adresse"><br>

        <label for="ville">Ville</label>
        <input type="text" name="ville" id="ville"><br>

        <label for="cp">Code postal</label>
        <input type="text" name="cp" id="cp"><br>

        <input type="submit" value="Envoi">
    </form>


</body>
</html>