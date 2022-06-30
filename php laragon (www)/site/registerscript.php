<?php
$pdo = require_once 'database-session.php';
$error = '';


//preparation de la gestion du formulaire
//on regarde d'abord si on a quelque chose dans le POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // puis récupération des variables
    $input = filter_input_array(INPUT_POST, [
        //FILTER_SANITIZE_FULL_SPECIAL_CHARS sert à filtrer uniquement les caractères
        //FILTER_SANITIZE_EMAIL sert à filtrer si on a bien une adresse mail
        'register-util' => FILTER_SANITIZE_FULL_SPECIAL_CHARS,
        'register-email' => FILTER_SANITIZE_EMAIL,
]);

// initialisation de toutes les variables
$username = $input['register-util'] ?? '';
$password = $_POST['register-mdp'] ?? '';
$email = $input['register-email'] ?? '';

//verifier si username ou password ou email n'a pas été ajouté puis affichage d'un message d'erreur
if (!$username || !$password || !$email) {
    $error = 'CHAMP INVALIDE';
}
else {
    $hashedPassword = password_hash($password, PASSWORD_ARGON2ID);

    $assoc = array(
        ':email'=>$email,
        ':username'=>$username,
        ':password'=>$hashedPassword
    );

    
    $statement = $pdo->prepare('INSERT INTO user(id_user,email,username,password) VALUES (
        DEFAULT,
        :email,
        :username,
        :password
        )');
        $statement->execute($assoc);

        header('Location:registeredvg.php');
}
}

?>

<?php require_once 'espace-client.php'; ?>

<?php if ($error): ?>
        <h1 style="color:red;"> <?= $error ?> </h1>
<?php endif; ?>