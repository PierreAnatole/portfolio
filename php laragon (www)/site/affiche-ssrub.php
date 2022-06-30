<?php 

function ssrub($r) {

        $pdo = require_once 'database.php';
        $requete = $pdo->prepare("SELECT * FROM sous_rubrique WHERE id_rub=?");
        $requete->execute(array($r));
        $rub = $requete->fetchall();
        $requete->closeCursor();

        return $rub;
}

?>