<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex2</title>
</head>
<body>
    <?php
    
    function somme ($t) {
        $res = 0;
        foreach ($t as $n) {
            $res += $n;
        }
        return $res;
    }

    $tab = array(4, 3, 8, 2);
    $resultat = somme($tab);
    echo $resultat;

    ?>
</body>
</html>