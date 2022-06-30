<?php require_once 'includes/database.php'; ?>

<?php
const ERROR_REQUIRED = 'veuillez renseigner une todo';
const ERROR_TOO_SHORT = 'veuillez rentrer au moins 5 caractères';

$error='';
$todo='';



if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $_POST = filter_input_array(INPUT_POST, FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $todo=$_POST['todo'] ?? '';

    if(!$todo) {
        $error=ERROR_REQUIRED;
    }
    else if(mb_strlen($todo) < 5) {
        $error=ERROR_TOO_SHORT;
    }

    if (!$error) {

        $assoc = array (
            ':name' => $todo
        );

        $stmt = $pdo->prepare("INSERT INTO list 
        (id_todo,name,done) VALUES 
        (DEFAULT,:name,0)");
        $stmt->execute($assoc);
        $stmt->closeCursor();
        $todo='';
    }
}

$stmtAff = $pdo->query("SELECT * FROM list");
$todos = $stmtAff->fetchall();

$stmtAff->closeCursor();


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <?php require_once 'includes/head.php' ?>
    <title>Todo</title>
</head>
<body>
    <div class="container">

        <?php require_once 'includes/header.php' ?>

        <div class="content">
            <div class="todo-container">
                <h1>Ma TODO</h1>
                <form class="todo-form" action="index.php" method="post">
                    <input type="text" name="todo" value="<?= $todo ?>">
                    <input class="btn btn-primary" type="submit" value="Ajouter">
                </form>
                <?php if ($error) : ;?>
                    <p class="text-danger"> <?= $error ?></p>
                <?php endif ;?>
                <ul class="todo-list">
                    <?php foreach ($todos as $t) : ?>
                        <li class="todo-item <?= $t->done ? 'low-opacity' : ''?>">
                            <span class="todo-name"> <?= $t->name ?></span>
                            <form action="edit-todo.php" method="POST">
                                <input type="hidden" name="edit-buffer" value="<?=$t->id_todo?>">
                                <input type="hidden" name="edit-status" value="<?= $t->done?>">
                                <button class="btn btn-primary"><?= $t->done ? 'Annuler' : 'Valider'?></button>
                            </form>
                            <form action="remove-todo.php" method="POST">
                                <input type="hidden" name="remove-buffer" value="<?=$t->id_todo?>">
                                <button class="btn btn-danger">Supprimer</button>
                            </form>
                            
                        </li>
                    <?php endforeach; ?>
                </ul>
            </div>
        </div>

        <?php require_once 'includes/footer.php' ?>

    </div>
    
</body>
</html>