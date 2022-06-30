<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Record</title>
</head>
<body>
    
    <?php

        try {
            $db = new PDO('mysql:host=localhost;charset=utf8;dbname=record', 'root', 'root');
            $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

            $requete = $db->query("SELECT * FROM artist");
            $tableau = $requete->fetchall(PDO::FETCH_OBJ);
            $requete->closeCursor();
        }

        catch (Exception $e) {
            echo "Erreur !: " . $e->getMessage() . "<br>";
            die();
        }

        echo "<table>";
        echo "<tr>
            <td>artist_id</td>
            <td>artist_name</td>
        </tr>";

        foreach ($tableau as $a) {
            echo "<tr>";
            echo "<td>",$a->artist_id,"</td>";
            echo "<td>",$a->artist_name,"</td>";
            echo "</tr>";
        }
        echo "</table>";
    ?>

</body>
</html>