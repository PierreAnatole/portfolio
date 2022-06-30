<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inscription/connexion</title>
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/espace-client.css">
    <link rel="stylesheet" href="styles/q_village.css">
</head>

<body>

    <div id=page>
        <?php require_once 'header.php'; ?>

        <main>
            <div id="forms">

                <div id="inscription">
                    <h2>Inscription</h2>

                    <form action="registerscript.php" method="post">

                        <label for="register-util">Nom utilisateur</label>
                        <input type="text" name="register-util" id="register-util">
                        
                        <label for="register-email">Email</label>
                        <input type="text" name="register-email" id="register-email">
                        
                        <label for="register-mdp">Mot de passe</label>
                        <input type="text" name="register-mdp" id="register-mdp">
                        
                        <input type="submit" value="valider">
                        
                    </form>
                </div>

                <div id="connexion">
                    <h2>Connexion</h2>

                    <form action="loginscript.php" method="post">

                        <label for="login-email">Email</label>
                        <input type="text" name="login-email" id="login-email">
                        
                        <label for="login-mdp">Mot de passe</label>
                        <input type="text" name="login-mdp" id="login-mdp">
                        
                        <input type="submit" value="connexion">
                    </form>
                </div>
            </div>
        </main>

    </div>

</body>
</html>