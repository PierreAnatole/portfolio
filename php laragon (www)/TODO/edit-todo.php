<?php 
require_once 'includes/database.php' ;

$_POST=filter_input_array(INPUT_POST,FILTER_SANITIZE_FULL_SPECIAL_CHARS);

$id = $_POST["edit-buffer"] ?? '';
$status = $_POST["edit-status"] ?? '';


if($id) {

    $stmt=$pdo->prepare("UPDATE list SET done=:stat WHERE id_todo=:id");
    $stmt->bindValue(':stat', ($status==='1') ? false : true , PDO::PARAM_BOOL);
    $stmt->bindValue(':id', $id, PDO::PARAM_INT);
    $stmt->execute();
    $stmt->closeCursor();
}
header("location: index.php");

?>