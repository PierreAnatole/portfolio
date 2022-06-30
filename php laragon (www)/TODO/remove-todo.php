<?php 
require_once 'includes/database.php' ;

$_POST=filter_input_array(INPUT_POST,FILTER_SANITIZE_FULL_SPECIAL_CHARS);

$id = $_POST["remove-buffer"] ?? '';
echo $id;


if($id) {

    $stmt=$pdo->prepare("DELETE FROM list WHERE id_todo=:id");
    $stmt->bindValue(':id', $id, PDO::PARAM_INT);
    $stmt->execute();
    $stmt->closeCursor();
}
header("location: index.php");

?>