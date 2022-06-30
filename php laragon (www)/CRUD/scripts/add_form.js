document.addEventListener("DOMContentLoaded", aff);

function aff() {
    document.querySelector("#form").addEventListener("submit", verif);

    function verif (e) {
        res=true;

        var filtre_nVide = /^.+$/;
        nVide = document.querySelectorAll('input[type=text]');
        for (var i of nVide) {
            if (!(filtre_nVide.test(i.value))) {
                alert('le champ '+i.id+' ne doit pas être vide');
                res=false;
            }
        }

        var filtre_year = /^[0-9]{0,4}$/;
        year = document.querySelector('#year');
        if (!(filtre_year.test(year.value))) {
            alert('year doit s\'écrire sous le format YYYY');
            res=false;
        }

        var filtre_dec = /^[0-9]+\.[0-9]+|[0-9]+$/;
        price = document.querySelector('#price');
        if (!(filtre_dec.test(price.value))){
            alert('price doit être un nombre ou un nombre à virgule (la virgule est un point)');
            res=false;
        }

        // affiche le message d'inscription ou empêche l'envoi du formulaire
        if (!(res)) {
            e.preventDefault();
        }
    }
}