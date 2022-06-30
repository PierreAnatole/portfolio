<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/q_village.css">
    <title>Envoi</title>
</head>
<body>
    <div id="page">
        <?php require_once 'header.php' ?>
        
        <?php
            $email=$_POST["email"];
            $subject=$_POST["sujet"];
            $message=$_POST["message"];

            $headers = array(
                'From' => $email
            );

            mail("test@test",$subject,$message,$headers);
        ?>

        <a href="village.php">Accueil</a>
    </div>
</body>
</html>