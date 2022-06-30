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
    echo $_POST["status"];
        if ($_POST["status"]=="connect") {
            $_SESSION["login"] = $_POST["user"];
        }
        else {
            unset($_SESSION["login"]);
            session_destroy();
            echo "deconnecté";
        }

    ?>

    <form action="verif.php" method="post">
        <input type="submit" value="test">

        <input type="hidden" name="buffer" value="<?= $_POST["user"] ?>">
    </form>
</body>
</html>