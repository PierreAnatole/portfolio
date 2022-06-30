<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="page.php" method="post">
        <label for="user">user</label>
        <input type="text" name="user" id="user">

        <label for="connect">connect</label>
        <input type="radio" name="status" id="connect" value="connect"checked>

        <label for="disconnect">disconnect</label>
        <input type="radio" name="status" id="disconnect" value="disconnect">

        <input type="submit" value="envoi">
    </form>

    <?php
        session_start();
        
    ?>


    
</body>
</html>