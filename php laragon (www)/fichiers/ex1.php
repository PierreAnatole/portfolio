<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex1</title>
</head>
<body>
    <?php
        
        function fileToLinks($filename){
            $links = file($filename);

            foreach ($links as $f) {
                echo '<a href="'.$f.'">'.$f.'</a>'."<br>";
            }
        }

        fileToLinks("files/liens.txt");
        
    ?>
</body>
</html>