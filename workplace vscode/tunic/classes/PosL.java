package tunic.classes;

/**
 * Enum représentant l'une des 12 lignes d'un symbole.
 * 
 * <p>
 * GH,DH,G,GB,DB pour une des 5 lignes exterieures.
 * (gauche haut, droite haut, gauche, gauche bad, droite bas).
 * </p>
 * 
 * <p>
 * dh,mh,gh,db,mb,gb,m pour une des 7 lignes intérieures.
 * (droite haut, milieu haut,gauche haut, droite bas, milieu bas, gauche bas, milieu).
 * </p>
 * 
 */
public enum PosL {
    DH,GH,G,GB,DB,dh,mh,gh,db,mb,gb,m;
}
