<?php
require_once 'includes/database.php';

$stmt=$pdo->query("SELECT * FROM article");
$articles=$stmt->fetchAll();
// echo "<pre>";
// var_dump($articles);
// echo "</pre>";

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <?php require_once 'includes/head.php' ?>
    <link rel="stylesheet" href="public/styles/index.css">
    <title>Blog</title>
</head>
<body>
    <div class="container">

        <?php require_once 'includes/header.php' ?>

        <div class="content">
            <div class="articles-container">
                <?php foreach($articles as $a): ?>
                    <div class="article box">
                        <div class="image-container" style="background-image: url(<?= $a->image?>);"></div>
                        <h2><?= $a->title ?></h2>
                    </div>
                <?php endforeach; ?>
            </div>
        </div>

        <?php require_once 'includes/footer.php' ?>

    </div>
    
</body>
</html>