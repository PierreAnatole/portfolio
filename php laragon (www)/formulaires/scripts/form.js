$(document).ready(function(){
    $("#form").submit(verif);

    function verif (e) {
        
        res=true;
        
        // véfifie que les champs textuels soit non vides
        var filtre_nVide = /^.+$/;
        nVide = $('input[type=text]');
        for (var i of nVide) {
            if (!(filtre_nVide.test(i.value))) {
                alert('le champ '+i.id+' ne doit pas être vide');
                res=false;
            }
        }

        // vérifie que le CIN contienne exactement 8 chfifres
        var cin = $("#cin");
        var filtre_huitChiffre = /^[0-9]{8}$/;
        if (!(filtre_huitChiffre.test(cin.val()))) {
            alert('le champ CIN doit contenir exactement 8 chiffres');
            res=false;
        }

        //  vérifie que l'adresse mail continenne le caractère @
        var mail = $("#mail");
        var filtre_mail = /(.*)[@](.*)/;
        if (!(filtre_mail.test(mail.val()))) {
            alert('le champs email doit contenir le caractère @')
            res=false;
        }

        // vérifie qu'au maximum 3 options sont séléctionnées
        var opts = $("#modules");
        var nbOptSelected = opts.val().length;
        if (nbOptSelected>2) {
            alert('seulement 2 modules maximum peuvent être sélectionnés');
            res=false;
        }

        // affiche le message d'inscription ou empêche l'envoi du formulaire
        if (res) {
            alert("Inscription achevée !!")
        }
        else {
            e.preventDefault()
        }
    }
    
});