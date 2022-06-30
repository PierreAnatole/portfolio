<?php include_once 'includes/database.php'; ?>

<?php 
const ERROR_REQUIRED = 'Veuillez renseigner ce champ';
const ERROR_TITLE_TOO_SHORT = 'Le titre est trop court';
const ERROR_CONTENT_TOO_SHORT = 'L\'article est trop court';
const ERROR_IMAGE = 'L\'image doit être une URL valide';

$errors = [
    "title" => '',
    "image" => '',
    "category" => '',
    "content" => ''
];

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $_POST = filter_input_array(INPUT_POST, [
        "title" => FILTER_UNSAFE_RAW,
        "image" => FILTER_SANITIZE_URL,
        "category" => FILTER_UNSAFE_RAW,
        "content" => ['filter' => FILTER_UNSAFE_RAW,'flags' => FILTER_FLAG_NO_ENCODE_QUOTES]
    ]);

    $title = $_POST['title'] ?? '';
    $image = $_POST['image'] ?? '';
    $category = $_POST['category'] ?? '';
    $content = $_POST['content'] ?? '';

    if (!$title) {
        $errors['title'] = ERROR_REQUIRED;
    } else if (mb_strlen($title)<3) {
        $errors['title'] = ERROR_TITLE_TOO_SHORT;
    };


    if (!$image) {
        $errors['image'] = ERROR_REQUIRED;
    } else if (!filter_var($image,FILTER_VALIDATE_URL)) {
        $errors['image'] = ERROR_IMAGE;
    };


    if (!$category) {
        $errors['category'] = ERROR_REQUIRED;
    };

    
    if (!$content) {
        $errors['content'] = ERROR_REQUIRED;
    } else if (mb_strlen($content)<50) {
        $errors['content'] = ERROR_CONTENT_TOO_SHORT;
    };


    
    if (empty(array_filter($errors, fn ($e) => $e !== ''))) {
        $stmt=$pdo->prepare("INSERT INTO article(id_article,title,image,category,content) VALUES (DEFAULT,:title,:image,:category,:content)");
        $stmt->bindValue(':title',$title);
        $stmt->bindValue(':image',$image);
        $stmt->bindValue(':category',$category);
        $stmt->bindValue(':content',$content);
        $stmt->execute();
        $stmt->closeCursor();
        header('Location: index.php');
    }
    
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <?php require_once 'includes/head.php'; ?>
    <link rel="stylesheet" href="public/styles/add_article.css">
    <title>Creer un article</title>
</head>

<body>

    <div class="container">

        <?php require_once 'includes/header.php' ?>

        <div class="content">
            <div class="block p-20 form-container">
                <h1>Écrire un article</h1>
                <form action="add_article.php" method="POST">
                    <div class="form-control">

                        <label for="title">Titre</label>
                        <input type="text" name="title" id="title" value="<?= $title ?? ''?>">

                        <?php if ($errors['title']): ?>
                            <p class="text-error"><?= $errors['title']?></p>
                        <?php endif; ?>
                    </div>
                    
                    <div class="form-control">
                        <label for="image">Image</label>
                        <input type="text" name="image" id="image" value="<?= $image ?? ''?>">
                        
                        <?php if ($errors['image']): ?>
                            <p class="text-error"><?= $errors['image']?></p>
                        <?php endif; ?>
                    </div>
                    
                    <div class="form-control">
                        <label for="category">Catégorie</label>
                        <select name="category" id="category">
                            <option value="technology">Technologie</option>
                            <option value="nature">Nature</option>
                            <option value="politics">Politique</option>
                        </select>
                        
                        <?php if ($errors['category']): ?>
                            <p class="text-error"><?= $errors['category']?></p>
                        <?php endif; ?>
                    </div>
                    
                    <div class="form-control">
                        <label for="content">Contenu</label>
                        <textarea name="content" id="content"><?= $content ?? ''?></textarea>
                        
                        <?php if ($errors['content']): ?>
                            <p class="text-error"><?= $errors['content']?></p>
                        <?php endif; ?>
                    </div>

                    <div class="form-actions">
                        <a href="index.php" class="btn btn-secondary" type="button">Annuler</a>
                        <button type="submit" class="btn btn-primary">Sauvegarder</button>
                    </div>
                    
                </form>
            </div>
        </div>

        <?php require_once 'includes/footer.php' ?>
    </div>

</body>
</html>