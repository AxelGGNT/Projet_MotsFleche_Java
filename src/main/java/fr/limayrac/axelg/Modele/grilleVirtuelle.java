package fr.limayrac.axelg.Modele;

import java.util.*;

public class grilleVirtuelle {
    Collection<Observer> lesObservers = new ArrayList<>();

    public void addObserver(Observer o) {
        lesObservers.add(o);
        System.out.println("Test observer ajouté");
    }

    public void removeObserver(Observer o) {
        lesObservers.remove(o);
        System.out.println("Test observer supprimé");
    }

    public void notifier() {
        for(Observer o: lesObservers){
        }
    }

    public void ajouterMot() {

    }

    public void getLargeur() {

    }

    public void getHauteur() {

    }

    public void getTableauCases() {

    }
}
