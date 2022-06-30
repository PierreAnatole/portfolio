DROP DATABASE blog;
CREATE DATABASE blog;
USE blog; 

CREATE TABLE article (
    id_article INT AUTO_INCREMENT,
    title varchar(255),
    image varchar(255),
    category varchar(50),
    content varchar(5000),
    PRIMARY KEY(id_article)
);

-- insert

INSERT INTO article(id_article,title,image,category,content) VALUES (DEFAULT,
"Parc national de Sembilang",
"https://i0.wp.com/rimbakita.com/wp-content/uploads/2019/08/burung-migran.jpg",
"nature",
"Le parc national de Sembilang est un parc national d'Indonésie créé en 2003 dans le sud-est de l'île de Sumatra. Il consiste en plus de 350 000 hectares de tourbières, de marais d'eau douce et de mangroves.
Le parc est protégé en tant que site Ramsar depuis le 3 juin 20112 et fait partie avec le parc national de Berbak de la réserve de biosphère Berbak-Sembilang, reconnue par l'Unesco en 20183."
),

(DEFAULT,
"Mini frigo xbox series X",
"https://www.micromania.fr/dw/image/v2/BCRB_PRD/on/demandware.static/-/Sites-masterCatalog_Micromania/default/dw4022322b/images/high-res/visuels%20produits%20news/Accessoires_Series/Frigo/17315_Front%20Open.jpg?sw=480&sh=480&sm=fit",
"technology",
"Ce qui a commencé par un meme est devenu une réalité lorsque nous avons créé le tout premier Frigo Xbox Series X, le plus rapide et le plus puissant des frigos. Une réplique parfaite de notre console adorée, mesurant plus d’1m80 et pesant près de 200 kilos. Mais nous ne nous sommes pas arrêtés là. Après une épique bataille des marques sur Twitter, Xbox est arrivé au sommet grâce à vos votes et nous nous sommes engagés à faire de vos memes de mini frigos une réalité. Nous avons surpris les fans avec un premier aperçu de notre design à la fin du Xbox Showcase de l’E3 dernier, et le moment est venu de vous proposer ce que vous attendiez : voici le mini frigo Xbox Series X.

Celui-ci a été créé en partenariat avec Ukonic!. Il affiche des LEDs et des textures semblables à celles de la Xbox Series X, de quoi impressionner vos amis tout en étanchant leur soif ! La tour noir mat peut contenir jusqu’à 12 canettes de votre breuvage préféré et dispose de deux étages dans sa porte, pour que vos en-cas soient toujours prêts. À l’avant du mini frigo, vous trouverez également une prise USB pour recharger vos appareils. Un adaptateur secteur sera fourni, pour que vous puissiez profiter du mini frigo lors de vos déplacements.

Le mini frigo arrivera pile à l’heure pour les fêtes de fin d’année, les précommandes commenceront le 19 octobre et vous pourrez le retrouver chez Micromania au prix de 99,99€.

Pour ne rien manquer de l’actualité du mini frigo thermoélectrique à l’image de la Xbox Series X, suivez notre compte Twitter @XboxFR et consultez le Xbox Wire en français régulièrement."
),

(DEFAULT,
"Strychnos usambarensis",
"https://upload.wikimedia.org/wikipedia/commons/f/ff/Strychnos_usambarensis01.jpg",
"nature",
"Strychnos usambarensis est une espèce de plantes dicotylédones de la famille des Loganiaceae, originaire de l'Afrique tropicale.

Ce sont des arbustes pouvant atteindre 5 mètres de haut ou de petits arbres très ramifiés de 10 à 15 mètres de haut, ou de grandes lianes, pouvant grimper dans les arbres jusqu'à 70 m de long. Ces plantes contiennent de nombreux alcaloïdes, dont certains ont un effet paralysant des muscles, analogue à celui du curare.

Les tribus bantoues du Rwanda et de Tanzanie produisent un poison de flèche à partir de l'écorce des racines et des feuilles de cette espèce, en les combinant parfois avec des extraits d'autres plantes.

L'épithète spécifique, usambarensis, est une référence aux monts Usambara de Tanzanie."
),

(DEFAULT,
"Philippe Etchebest",
"https://yt3.ggpht.com/ytc/AKedOLR3uFUrGV1oZ3mQ0eWly_0IKLT8fCQCbRGPsw2YmQ=s900-c-k-c0x00ffffff-no-rj",
"politics",
"Philippe Etchebest, né le 2 décembre 1966 à Soissons (Aisne), est un chef cuisinier et un animateur de télévision français.

Depuis 2014, il est juré de Top Chef (saisons 6 et suivantes), et anime les émissions Objectif Top Chef, Cauchemar en cuisine et Cauchemar à l'hôtel.

Carrière professionnelle
Ses débuts dans le Sud et à Paris
En 1985, Philippe Etchebest rejoint son père en cuisine au Chipiron6. Il cherche à développer son propre art culinaire en réalisant des stages de deux mois pendant les périodes estivales13. En 1986, il intègre d'abord l'hôtel-restaurant Les Pyrénées, établissement deux macarons situé à Saint-Jean-Pied-de-Port (Pyrénées-Atlantiques), sous la direction du chef Firmin Arrambide13. Philippe Etchebest y cuisine pour la première fois des produits nobles13. La même année, il participe à nouveau au concours Exp'Hôtel et en sort vainqueur14. En 1987, il réalise un stage à Tours, auprès du chef Jean Bardet15, puis un deuxième à Cannes, auprès de chef doublement étoilé Jacques Chibois, qui l'incite à quitter le cocon familial pour rejoindre Paris en 198816.

À l'âge de 22 ans, Philippe Etchebest suit les recommandations de Jacques Chibois et intègre les cuisines du Clos Longchamp, le restaurant de l'hôtel Le Méridien Étoile, en tant que demi-chef de partie puis chef de partie six mois plus tard17. Auprès du chef Jean-Marie Meulien, Philippe Etchebest dit avoir appris l'équilibre des saveurs et l'usage des épices pour élargir la palette des goûts18. Un an après son entrée au sein de la brigade au Clos Longchamp, il est promu au poste de second de cuisine, mais a, dans un premier temps, des difficultés à imposer son autorité à cause de son âge et de son manque d'expérience19. En 1989, il remporte le concours Minervois-jeune, présidé cette année-là par Joël Robuchon20.

En 1990, le Clos Longchamp devient le premier restaurant d'une chaîne hôtelière à recevoir deux étoiles au Guide Michelin21. Cette même année, Philippe Etchebest fait sa première apparition télévisée lorsqu'il doit remplacer le chef du Clos Longchamp, Jean-Marie Meulien, dans une émission présentée par Caroline Tresca sur FR322.

En 1993, alors qu'il travaille désormais comme second auprès de Dominique Toulousy, aux Jardins de l'Opéra à Toulouse23, Philippe Etchebest remporte le prix international Paul-Louis Meissonnier, en équipe avec son collègue, le sommelier Patrick Guiral20."
),

(DEFAULT,
"King Harkinian",
"https://pbs.twimg.com/profile_images/845134913695244288/U3FYujB8_400x400.jpg",
"politics",
"King Harkinian is a recurring character in various non-canonical Legend of Zelda products. He is the King of Hyrule in the media in which he appears and serves head of the Royal Family of Hyrule in them as well.

King Harkinian is a popular inclusion in YouTube Poop videos on YouTube, and many of his quotes from Link: The Faces of Evil and Zelda: The Wand of Gamelon, such as My boy and dinner, are particularly popular in these videos."
),

(DEFAULT,
"Mini frigo xbox series X",
"https://www.micromania.fr/dw/image/v2/BCRB_PRD/on/demandware.static/-/Sites-masterCatalog_Micromania/default/dw4022322b/images/high-res/visuels%20produits%20news/Accessoires_Series/Frigo/17315_Front%20Open.jpg?sw=480&sh=480&sm=fit",
"technology",
"Ce qui a commencé par un meme est devenu une réalité lorsque nous avons créé le tout premier Frigo Xbox Series X, le plus rapide et le plus puissant des frigos. Une réplique parfaite de notre console adorée, mesurant plus d’1m80 et pesant près de 200 kilos. Mais nous ne nous sommes pas arrêtés là. Après une épique bataille des marques sur Twitter, Xbox est arrivé au sommet grâce à vos votes et nous nous sommes engagés à faire de vos memes de mini frigos une réalité. Nous avons surpris les fans avec un premier aperçu de notre design à la fin du Xbox Showcase de l’E3 dernier, et le moment est venu de vous proposer ce que vous attendiez : voici le mini frigo Xbox Series X.

Celui-ci a été créé en partenariat avec Ukonic!. Il affiche des LEDs et des textures semblables à celles de la Xbox Series X, de quoi impressionner vos amis tout en étanchant leur soif ! La tour noir mat peut contenir jusqu’à 12 canettes de votre breuvage préféré et dispose de deux étages dans sa porte, pour que vos en-cas soient toujours prêts. À l’avant du mini frigo, vous trouverez également une prise USB pour recharger vos appareils. Un adaptateur secteur sera fourni, pour que vous puissiez profiter du mini frigo lors de vos déplacements.

Le mini frigo arrivera pile à l’heure pour les fêtes de fin d’année, les précommandes commenceront le 19 octobre et vous pourrez le retrouver chez Micromania au prix de 99,99€.

Pour ne rien manquer de l’actualité du mini frigo thermoélectrique à l’image de la Xbox Series X, suivez notre compte Twitter @XboxFR et consultez le Xbox Wire en français régulièrement."
);