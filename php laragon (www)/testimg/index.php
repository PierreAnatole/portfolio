<?php 
const ERROR_URL_NOT_VALID = 'URL non valide';
$error='';
$image='';

if($_SERVER["REQUEST_METHOD"] === "POST") {
    $image=$_POST["image"];
    if (filter_var($image,FILTER_VALIDATE_URL)) {
        $error="";
    } else {
        $error=ERROR_URL_NOT_VALID;
        $image="";
    }
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="public/styles//style.css">
    <title>TestIMG</title>
</head>
<body>

<form action="index.php" method="POST">
    <label for="image">Image :</label>
    <input type="text" name="image" id="image">
    <?php if ($error) :?>
        <p class="text-danger"> <?= $error ?></p>
    <?php endif ;?>
    <button type="submit">Tester</button>
</form>

<div class="image-container" style="background-image: url(<?= $image ?>);"></div>

</body>
</html>