<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercices</title>
</head>
<body>
    <?php
    // IMPORTANT : fixe le fuseau horaire à celui de la france.
    date_default_timezone_set("Europe/Paris");
    
    // 1/
    // pour afficher le numéro de semaine dans l'année, l'option de formatage utilisée est "W".
    $d = new DateTime("2019-07-14");
    echo "numéro de semaine du 2019-07-14 : ",$d->format("W"),"<br><br>";

    // 2/
    // date_diff calcule la différence entre deux dates.
    $end = new DateTime("2022-09-28");
    $now = new DateTime();
    $interval = date_diff($now,$end);
    echo "nombre de jours avant la fin de la formation : ",$interval->format("%a"),"<br><br>";

    // 3/
    // pour afficher si une année est bissextile, l'option de formatage utilisée est "L".
    // affiche '1' si l'année est bissextile, '0' sinon.
    function isBissextile ($d) {
        $res;
        ($d->format("L")=='1') ? $res='true' : $res='false';
        return $res;
    }

    echo "l'année 2022 est bissextile : ",isBissextile(new DateTime("2022-01-01")),"<br>";
    echo "l'année 2020 est bissextile : ",isBissextile(new DateTime("2020-01-01")),"<br>";
    echo "l'année 2100 est bissextile : ",isBissextile(new DateTime("2100-01-01")),"<br>";
    echo "l'année 2000 est bissextile : ",isBissextile(new DateTime("2000-01-01")),"<br><br>";

    // 4/
    // DateTime::createFromFormat crée une date à partir d'un format spécifié.
    // si la création de date renvoie une erreur (date non valide), DateTime::getLastErrors() renvoie un array contenant
    // le nombre d'erreur et de warning de la dernière création de date. Si l'un des deux est positif, c'est que la création
    // de date à échoué.
    function testDate($s) {
        $test = DateTime::createFromFormat('d/m/Y', $s);

        $errors = DateTime::getLastErrors();

        if ($errors["error_count"]>0 || $errors["warning_count"]>0) {
            return 'false';
        }
        else {
            return 'true';
        }

    }
    echo "format : JJ/MM/AAAA<br>";

    echo "32/17/2019 est elle une date valide ? ",testDate("32/17/2019"),"<br>";
    echo "29/02/2022 est elle une date valide ? ",testDate("29/02/2022"),"<br>";
    echo "29/02/2020 est elle une date valide ? ",testDate("29/02/2020"),"<br><br>";


    // 5/
    // on échappe le caractère h avec \.
    $now = new DateTime();
    echo "heure courante : ",$now->format("H\hi"),"<br><br>";

    // 6/
    // format des DateInterval exemple : 
    // P10D : correspond à 10 jours (P obligatoire, 10D 10jours)
    // P7Y5M4DT4H3M2S : P obligatoire (partie jours), 7Y (7ans), 5M (5 mois), 4D (4jours), T obligatoire (partie temps),
    // 4H3M2S (4heures, 3minutes, 2secondes)
    $now = new DateTime();
    echo "date du jour : ", $now->format("d/m/Y"),"<br>";

    function addOneMonth ($d) {

        $oldDay = $d->format("d");
        $d->add(new DateInterval("P1M")); // "P1M" correspond a une durée d'un mois
        $newDay = $d->format("d");


        // corrige dans le cas ou on ajoute par exemple 1 mois à "2022-01-31" :
        // (afficherait 2022-03-03) car 2022-02-31 n'est pas une date valide.
        if($oldDay != $newDay) {
            // Check if the day is changed, if so we skipped to the next month.
            // Substract days to go back to the last day of previous month.
            $d->sub(new DateInterval("P" . $newDay . "D"));
        }

        return $d;
    }

    addOneMonth($now);
    echo "date du jour + un mois : ", $now->format("d/m/Y"),"<br><br>";

    // 7
    // setTimestamp permet de changer l'attribut timestamp d'une date.
    $ts = (new DateTime())->setTimestamp(1000200000);
    echo "date correspondant au timestamp 1000200000 : ", $ts->format("d/m/Y"),"<br>";

    ?>
</body>
</html>