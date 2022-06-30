<?php
    try {
        $pdo = new PDO('mysql:host=localhost;charset=utf8;dbname=todo', 'root', 'root');
        $pdo -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_OBJ);
    }

    catch (PDOException $e){
        echo $e->getMessage();
    }

    return $pdo;
    
?>