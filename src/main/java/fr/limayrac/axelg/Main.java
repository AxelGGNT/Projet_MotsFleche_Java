package fr.limayrac.axelg;

import fr.limayrac.axelg.Modele.*;

public class Main {
    public static void main(String[] args) {
        Grille grid = new Grille(10, 10);
        grid.ajouterMot("goodbye",3,2, "H");
        grid.ajouterMot("bonjour",2,1, "V");
        grid.ajouterDef(5,5,"Déf");
        grid.dumpGrille();
        System.out.println(grid.findCaseDef(5,5));
        System.out.println(grid.findCaseDispo(2,5,"V"));
        grid.supprimerDef(5,5);
        grid.findCaseDef(5,5);
        /*Fichier f = new Fichier();
        f.printMots();*/
    }
}
