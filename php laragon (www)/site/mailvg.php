<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/mailvg.css">
    <link rel="stylesheet" href="styles/q_village.css">
    <title>Mails</title>
</head>
<body>
    <div id=page>
        <?php require_once 'header.php'; ?>

        <main>
            <h2>Contactez nous</h2>
            <form action="sendmail.php" method="post">
                <label for="email">Email</label>
                <input type="text" name="email" id="email">
                
                <label for="sujet">Sujet</label>
                <input type="text" name="sujet" id="sujet">
                
                <label for="message">Message</label>
                <textarea name="message" id="message"></textarea>

                <input type="submit" value="envoi">
            </form>
        </main>
    </div>

</body>
</html>