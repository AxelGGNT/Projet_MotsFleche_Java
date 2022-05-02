package fr.limayrac.axelg.Modele;

import java.util.ArrayList;

public class Grille {
    private int hauteur;
    private int largeur;
    public char[][] tabGrille;

    private ArrayList<CaseDef> CasesDefs = new ArrayList<CaseDef>();

    // Getters & Setters
    public char[][] getTabGrille() {
        return tabGrille;
    }

    public void setTabGrille(char[][] tabGrille) {
        this.tabGrille = tabGrille;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    // Constructor
    public Grille(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        tabGrille = new char [largeur][hauteur];
        initTableau();
    }

    // Méthodes grilles
    private void initTableau(){
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                tabGrille[l][h] = '.';
            }
        }
    }

    public void dumpGrille(){
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                System.out.print(tabGrille[l][h]);
            }
            System.out.println();
        }
    }

    public boolean ajouterMot(String mot, int x, int y, String direction){
        // A préciser
        if(mot.length() > largeur){
            System.out.println("Le mot ajouté est trop long.");
            return false;
        }
            // Horizontal (x) = gauche / droite | Vertical (y) = haut / bas
            // Si la direction choisie est verticale
            if (direction.equals("V")){
                for (int i = 0; i < mot.length(); i++) {
                    tabGrille[i+x][y] = mot.charAt(i);
                }
            }
            else {
                // Sinon c'est à l'horizontale
                for (int i = 0; i < mot.length(); i++) {
                    tabGrille[x][y+i] = mot.charAt(i);
                }
            }
            //notifyObservateur();
        return true;
    }

    // Gestion des définitions
    public void ajouterDef(int x, int y, String libDef){
        CaseDef caseDef = new CaseDef(x, y, libDef);
        CasesDefs.add(caseDef);
    }

    // A refaire
    public void supprimerDef(int x, int y){
        CasesDefs.forEach((caseDef) -> {
            if(caseDef.positionX == x && caseDef.positionY == y){
                CasesDefs.remove(caseDef);
            }
        });
    }

    public CaseDef findCaseDef(int x, int y){
        for(CaseDef caseDef : CasesDefs) {
            if (caseDef.positionX == x && caseDef.positionY == y) {
                return caseDef;
            }
        }
        return null;
    }

    public int findCaseDispo(int x, int y, String direction){
        int cptDispo = 0;
        // Si la direction choisie est horizontale (gauche --> droite)
        if(direction.equals("H")){
            do {
                y++;
                cptDispo++;
            }
            while(y < hauteur && findCaseDef(x, y) == null);
            return cptDispo;
        }
        // Sinon c'est vertical (Haut --> bas)
        else{
            do {
                x++;
                cptDispo++;
            }
            while(x < largeur && findCaseDef(x, y) == null);
            return cptDispo;
        }
    }
}
