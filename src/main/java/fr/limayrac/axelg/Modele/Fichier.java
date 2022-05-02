package fr.limayrac.axelg.Modele;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fichier {
	private static final String FICHIER = "liste_francais.txt";
	private ArrayList <String> listeDeMots = null;
	
	public Fichier() {
		super();
		listeDeMots = new ArrayList<>();
		ouvrirFichier();
	}
	
	private void ouvrirFichier(){
		try{
			InputStream flux = Fichier.class.getResourceAsStream(FICHIER);
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				listeDeMots.add(ligne);
			}
			buff.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

	public void printMots(){
		System.out.println("affichage des mots présents dans le dictionnaire");
		for (String m  : listeDeMots) {
			System.out.println(m);
		}
	}
		
	public void printMotsDebut(String d){
			System.out.printf("affichage des mots commençant par %s%n", d);
			int i = 0;
			for (String mot : listeDeMots) {
				i++;
			}
			System.out.println(i);
			for (String m  : listeDeMots) {
				if (m.startsWith(d)){
					System.out.println(m);
				}
			}
	}
}
