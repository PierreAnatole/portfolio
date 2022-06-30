<?php
try {    
    $pdo = new PDO('mysql:host=localhost;charset=utf8;dbname=sessionvg', 'root', 'root',[PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC]);
  
  } catch (PDOException $e) {
      echo $e->getMessage(); 
      
  } 
  return $pdo; 
?>