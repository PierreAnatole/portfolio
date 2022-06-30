<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex3</title>
    <link rel="stylesheet" href="styles/ex3.css">
</head>
<body>
    

    
    <?php
        echo "<table>";

        // première ligne
        echo "<tr>";
        for ($head=0; $head<10 ; $head++) { 
            echo '<td class="bold">'.$head."</td>";
        }
        echo "</tr>";

        
        for ($i=1; $i<10 ; $i++) {
            echo "<tr>";
            // premiere case de chaque ligne
            echo '<td class="bold">'.$i."</td>";
            for ($j=1; $j<10 ; $j++) {
                echo "<td>".$i*$j."</td>";
            }
            echo "</tr>";
        }

        echo "</table>";
    ?>
</body>
</html>