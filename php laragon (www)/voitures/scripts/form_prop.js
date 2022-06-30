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

        var filtre_cp = /^[0-9]{5}$/;
        cp = document.querySelector('#cp');
        if (!(filtre_cp.test(cp.value))){
            alert('code postal : nombre a 5 chiffres');
            res=false;
        }

        // affiche le message d'inscription ou empêche l'envoi du formulaire
        if (!(res)) {
            e.preventDefault();
        }
    }
}