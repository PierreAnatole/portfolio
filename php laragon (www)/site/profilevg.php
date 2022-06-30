<?php
require_once './isLoggedin.php';
$currentUser = isLoggedIn();
//var_dump($currentUser['username']); die;
if (!$currentUser) {
    header('Location:  /loginvg.php');
}/*
$pdo = require_once './database-session.php';
$sessionId = $_COOKIE['session'] ?? '';
if ($sessionId) {
    $sessionUserStatement = $pdo->prepare("SELECT * FROM session JOIN user on user.id=session.userId WHERE session.id=?");
    $sessionUserStatement ->execute([$sessionId]);
    $user = $sessionUserStatement->fetch();*/
   /* if ($session) {
        $userStatement = $pdo->prepare('SELECT * FROM user WHERE id=?');
        $userStatement->execute([$sessionId['userId']]);
        $user = $userStatement->fetch();
    } 
    
}*/

/*if (!$user) {
    header('Location: /login.php');
}*/
?>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name= "viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <nav>
           <!-- <a href="/Filrouge/Villagegreen.php">Retour Village</a>
            <a href="loginvg.php">Connexion</a>
            <a href="logout.php">Déconnexion</a>
            <a href="profilevg.php">Profil</a>
            <a href="registerscript.php">Inscription</a> 
            <a href="/profilevg.php">Profil</a>-->
            <a href="/logoutvg.php">Déconnexion</a>
        </nav>   
        <h1>PROFIL</h1>
        <h2> Bonjour <?= $currentUser['username'] ?></h2>
    </body>
</html>