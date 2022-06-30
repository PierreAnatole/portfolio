<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>classes</title>
</head>
<body>
    <?php

        class Animal {

            public string $nom;

            public function __construct(string $name){
                $this->nom=$name;
            }

            public function cri(){}

            public function infos(){
                echo "je suis un ".$this->nom;
            }

        }

        class Felin extends Animal {
            
            public function rugir(){}

            public function infos(){
                parent::infos();
                echo ", je possède des griffes";
            }

        }

        class Chat extends Felin {

            public function rugir(){
                echo "miaou";
            }

            public function infos(){
                parent::infos();
                echo ", je suis domestiqué";
            }

        }

        class Lion extends Felin {

            public function rugir(){
                echo "Rrrr";
            }

            public function infos(){
                parent::infos();
                echo ", j'habite dans la nature";
            }

        }

        echo "<br>";

        $lion = new Lion("lion");
        $lion->infos();
        echo "<br>";
        echo $lion->rugir();

        echo "<br>";

        $chat = new Chat("chat");
        $chat->infos();
        $chat->rugir();


        
    ?>
</body>
</html>