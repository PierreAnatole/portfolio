<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/village.css">
    <link rel="stylesheet" href="styles/q_village.css">
    <title>Village Green</title>
    <script src="scripts/hover-categories.js"></script>
    <!-- <script src="scripts/hover-topvente.js"></script> -->
    
</head>
<body>
    <div id=page>
        <?php require_once 'header.php'; ?>
    

        <main>
            <div id="l-pub">
                <img src="images/BODY/pub guitare.png" alt="guitare-pub">
                <img src="images/BODY/banniere droite prix.png" alt="banner-r">
            </div>

            <img src="images/BODY/banniere centre 4 pictos.png" alt="banner-c">

            <div id="l-categories">
                <span class="txtstyle">Nos&nbsp;catégories</span>
                <div id="imcategories">
                    <img src="images/BODY/CATEGORIES/corde.png" alt="img-corde" class="imcat" id="corde">
                    <img src="images/BODY/CATEGORIES/percu.png" alt="img-percu" class="imcat" id="percu">
                    <img src="images/BODY/CATEGORIES/vent.png" alt="img-vent" class="imcat" id="vent">
                    <img src="images/BODY/CATEGORIES/clavier.png" alt="img-clavier" class="imcat" id="clavier">
                    <img src="images/BODY/CATEGORIES/m-instru.png" alt="img-m-instru" class="imcat" id="m-instru">
                    <img src="images/BODY/CATEGORIES/accessoire.png" alt="img-accessoire" class="imcat" id="accessoire">
                </div>
            </div>

            <div id="l-vente_part">
                <div id="vente">
                    <span class="txtstyle">Nos meilleures ventes</span>
                    <div id=imtopvente>
                        <img src="images/BODY/TOP VENTES/tv-guitare.png" alt="img-tpv-guitare" class="imtpv" id="tv-guitare">
                        <img src="images/BODY/TOP VENTES/tv-saxo.png" alt="img-tpv-saxo" class="imtpv" id="tv-saxo">
                        <img src="images/BODY/TOP VENTES/tv-piano.png" alt="img-tpv-piano" class="imtpv" id="tv-piano">
                    </div>
                </div>
                <div id=partenaires>
                <span class="txtstyle">Nos partenaires</span>
                <img src="images/BODY/partenaires 4 logos.png" alt="partenaires">
                </div>
            </div>

        </main>

        

    </div>

    <footer>
        <img src="images/FOOTER/footer.png" alt="">
    </footer>
    
</body>
</html>