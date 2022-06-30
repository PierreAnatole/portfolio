<?php
    try {
        $pdo = new PDO('mysql:host=localhost;charset=utf8;dbname=test', 'root', 'root');
    }

    catch (PDOException $e){
        echo $e->get_message();
    }
    
    return $pdo;
?>