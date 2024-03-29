package fr.benab.projet1.game;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

	private static Logger logger = LogManager.getLogger(Test.class);

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Escape game");
		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean menu = false;
			int choice = 0;
			String saisie;
			boolean play = false;
			while (!menu) {
				System.out.println("\r\n0: Exit");
				System.out.println("1: Mode Challeger");
				System.out.println("2: Mode Defense");
				System.out.println("3: Mode Duel");

				try {
					saisie = sc.nextLine();
					logger.info("Choix du menu saisie");
					choice = Integer.parseInt(saisie);
					if (choice < 0 || choice > 3) {
						logger.warn("Le chiffre n'est pas compris entre 0 et 3");
					} else {
						menu = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Votre saisie ne correspond pas aux choix du menu propos�s");
				}
			}
			while (!play) {
				if (choice == 0) {
					System.out.println("You have choicen to exit this program");
					System.out.println("Goodbay !");
					sc.close();
					System.exit(0);
				}

				Game game = new Game(choice);
				if (choice == 3) {
					game.multiPlayer();
				} else {
					game.treatment();
				}

				System.out.println("Game again of same mode ? (Y/N)");
				String response = sc.nextLine();

				if (response.charAt(0) == 'Y' || response.charAt(0) == 'y') {
					System.out.println("Play again !");
				} else play = true;
					
			}
		}
	}
}
