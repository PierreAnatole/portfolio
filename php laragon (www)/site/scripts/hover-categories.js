document.addEventListener("DOMContentLoaded", aff);

function aff () {
    
    // collection des elements à hover et leur chemin d'accès
    // 
    // clé : l'id des objets à hover
    // value : tableau [x,y]
    // x : chemin d'accès de l'image de la clé correspondante
    // y : chemin d'accès de l'image "roll over" de la clé correspondante
    var mapHover = new Map();

    // fonction permettant de remplir la collection avec les images d'un dossier avec le format suivant :
    // id : [ path+id+.png , path+id+ ROLL OVER.png ]
    //
    // path : le chemin d'accès vers le dossier d'images
    // t : un tableau contenant l'id des images à ajouter à la collection
    function addToMap (path,t) {
        for (let i of t) {
            mapHover.set(i,[path+i+".png",path+i+" ROLL OVER.png"]);
        }
    }

    addToMap("images/BODY/CATEGORIES/",
    ["corde","percu","vent","clavier","m-instru","accessoire"]);

    addToMap("images/BODY/TOP VENTES/",
    ["tv-guitare","tv-saxo","tv-piano"]);



    var item;
    // ajoute 2 event listener pour chaque élement de la map.
    // l'un s'active quand la souris est sur l'element et transforme l'image dans sa version "hovered"
    // l'autre s'active lorsque la souris quitte l'element et transforme l'image dans sa version normale.
    for (var [i,x] of mapHover) {
        item = document.getElementById(i);
        item.addEventListener("mouseover", hover);
        item.addEventListener("mouseout", notHover);
    }

    function hover(e) {
        e.currentTarget.src=mapHover.get(e.currentTarget.id)[1];
    }

    function notHover(e) {
        e.currentTarget.src=mapHover.get(e.currentTarget.id)[0];
    }

}


