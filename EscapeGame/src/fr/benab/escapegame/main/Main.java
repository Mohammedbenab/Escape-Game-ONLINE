package fr.benab.escapegame.main;

import java.util.Scanner;

import fr.benab.escapegame.joueurs.Attaquant;
import fr.benab.escapegame.joueurs.Joueurs;


public class Main {

	public static void main(String[] args) {
		
		String reponse = "O";
		String jouer;
		//Joueurs attaquant = new Attaquant();
		
		while (reponse == "O") {
			
			reponse =null;
			jouer = null;
			Joueurs attaquant = new Attaquant();
			attaquant.menuChoixUtilisateur();
			
			System.out.println("Souttez-vous rejouer ? O/N");
			Scanner sc = new Scanner(System.in);
			jouer = sc.nextLine();
			
			if (jouer == "O" || jouer == "o" || jouer == "Oui" || jouer == "oui") {
				reponse = "O";
			}else {
				System.out.println("Merci d'avoir participer, et à bientôt !");
				reponse = "N";
			}
		}
	}

}
