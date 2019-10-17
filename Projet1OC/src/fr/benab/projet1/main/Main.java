package fr.benab.projet1.main;

import java.util.Scanner;

import fr.benab.projet1.creatGame.BuildGame;
import fr.benab.projet1.creatGame.Builder;
import fr.benab.projet1.creatGame.Menu;


public class Main {

	public static void main(String[] args) {
		
		String reponse = "O";
		
		while (reponse.charAt(0)=='O'|| reponse.charAt(0) == 'o') {
			reponse = "";
			Menu menu = (new BuildGame(new Menu())).creatMenu();
			menu.menuChoicePlayer();
			System.out.println("Voulez vous rejouer une partie ?(O/N)");
			Scanner sc = new Scanner(System.in);
			reponse = sc.nextLine();
			
		}
		

		

	}

}
