<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire</title>
    <link rel="stylesheet" href="styles/form.css">
    <script src="scripts/jquery-3.6.0.min.js"></script>
    <script src="scripts/form.js"></script>
   

</head>
<body>

    <h1>INSCRIPTION</h1>

    <form action="action.php" method="post" id="form">

        <label for="nomPrenom">Nom et prénom*:</label>
        <input type="text" name="nomPrenom" id="nomPrenom">
        <br><br>

        <label for="cin">CIN*:</label>
        <input type="text" name="cin" id="cin">
        <br><br>

        <label for="mail">Adresse e-mail*:</label>
        <input type="text" name="mail" id="mail">
        <br><br><br>

        <span>Niveau : </span>
        <div id=radio>
            <input type="radio" name="niveau" value ="secondaire" id="niveauChoice1" checked="true">
            <label for="niveauChoice1">Secondaire</label>

            <input type="radio" name="niveau" value ="universitaire" id="niveauChoice2">
            <label for="niveauChoice2">Universitaire</label>

            <input type="radio" name="niveau" value ="autre" id="niveauChoice3">
            <label for="niveauChoice3">Autre</label>
        </div>
        <br>

        <label for="modules">Modules et formation :</label>
        <br>
        <select name="modules[]" id="modules" multiple="multiple">
            <option value="bureautique" id=bureautique>Bureautique</option>
            <option value="se-resInfo" id="se-resInfo"> SE et Réseaux info.</option>
            <option value="TIC" id="TIC">TIC</option>
        </select>

        <div id=obl>
            (*) Champs Obligatoires
        </div>

        <input type="submit" value="envoyer" id="envoyer">
        <input type="reset" value="annuler" id="annuler">

    </form>  

</body>
</html>