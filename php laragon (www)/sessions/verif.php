<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        session_start();
        if ($_SESSION["login"]) {
            echo "connecté, bonjour ".$_POST["buffer"];
        }
        else {
            echo "deconnecté";
        }
    
    ?>

    <form action="accueil.php">
        <input type="submit" value="retour">
    </form>
</body>
</html>