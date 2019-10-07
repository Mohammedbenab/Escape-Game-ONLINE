package fr.benab.escapegame.main;

import java.util.Scanner;

import fr.benab.escapegame.joueurs.Attaquant;
import fr.benab.escapegame.joueurs.Joueurs;


public class Main {

	public static void main(String[] args) {
		
		String jouer = "O";
		Joueurs attaquant = new Attaquant();
		
		while (jouer == "O" || jouer == "o" || jouer == "Oui" || jouer == "oui") {
			
			jouer = "";
			
			//Joueurs attaquant = new Attaquant();
			attaquant.menuChoixUtilisateur();
			
			System.out.println("Souttez-vous rejouer ? O/N");
			Scanner sc = new Scanner(System.in);
			String reponse = sc.nextLine();
			
			if (reponse == jouer) {
				jouer = "O";
			}else {
				System.out.println("Merci d'avoir participer, et à bientôt !");
				System.out.println(reponse + jouer);
				jouer = "N";
			}
		}
	}

}
