<?php
    $pdo=require_once 'database.php';
    if ($_SERVER['REQUEST_METHOD'] === 'POST'){
        $input = filter_input_array(INPUT_POST, [
            'username' => FILTER_SANATIZE_FULL_SPECIAL_CHARS,
            'email' => FILTER_SANATIZE_EMAIL,
        ]);

        $error="";
        $username=$input['username'] ?? "";
        $password = $_POST['password'] ?? "";
        $email = $input['email'] ?? "";
        
    }
    else {

    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
</head>
<body>
    <nav>
        <a href="index.php">Accueil</a>
        <a href="login.php">Connexion</a>
        <a href="logout.php">Déconnexion</a>
        <a href="profile.php">Profil</a>
        <a href="register.php">Inscription</a>
    </nav>   
    <h1>Inscription</h1>
</body>
</html>