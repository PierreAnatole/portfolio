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

    function lien ($link,$title) {
        return '<a href="'.$link.'">'.$title.'</a>';
    }

    echo lien("https://www.reddit.com/", "Reddit Hug");
    
    ?>
</body>
</html>