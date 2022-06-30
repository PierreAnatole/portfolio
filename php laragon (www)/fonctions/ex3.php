<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex3</title>
</head>
<body>
    <?php

    function complex_password($s) {
        $res = 'true' ;
        if (!(preg_match('/.{8}/',$s))) {
            $res = 'false';
        }
        if (!(preg_match('/[0-9]+/',$s))) {
            $res = 'false';
        }
        if (!(preg_match('/([a-z]+.*[A-Z]+)|([A-Z]+.*[a-z]+)/',$s))) {
            $res = 'false';
        }
        return $res;
    }
    
    $resultat = complex_password("TopSecret42");
    echo $resultat;
    
    ?>
</body>
</html>