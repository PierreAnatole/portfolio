document.addEventListener("DOMContentLoaded", aff);

function aff () {

    var path ="images/BODY/TOP VENTES/"

    // id des élements roll over
    var cat = ["tv-guitare","tv-saxo","tv-piano"];
    var mapInstru = new Map();
    for (i of cat) {
        mapInstru.set(i,[path+i+".png",path+i+" ROLL OVER.png"]);
    }

    var item;
    for (i of cat) {
        item = document.getElementById(i);
        item.addEventListener("mouseover", func);
        item.addEventListener("mouseout", func1);
    }

    function func(e) {
        e.currentTarget.src=mapInstru.get(e.currentTarget.id)[1];
    }

    function func1(e) {
        e.currentTarget.src=mapInstru.get(e.currentTarget.id)[0];
    }

}


