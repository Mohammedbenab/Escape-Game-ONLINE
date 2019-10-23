package fr.benab.projet1.main;

import java.util.Scanner;


import fr.benab.projet1.game.Game;

public class Main {

	public static void main(String[] args) throws Exception{

		//Game game = new Game();
		while (true) {
			boolean play = false;
			int choice = 0;
			Scanner sc = new Scanner(System.in);
			
			while (!play) {
				
				System.out.println("0: Exit");
				System.out.println("1: Mode Challeger");
				System.out.println("2: Mode Defense");
				System.out.println("3: Mode Duel");
				try {
					choice = Integer.parseInt(sc.nextLine());
					if (choice < 0 || choice > 3) {
						System.err.println("Can you choice number of menu mode");
					}else play = true;
				}catch (Exception e) {
					e.printStackTrace();
					System.err.println("Error in your choice !");
				}
			}
			//sc.close();
			
			if (choice == 0) {
				System.out.println("You have choicen to exit this program");
				System.out.println("Goodbay !");
				break;
			}
			
			Game game = new Game(choice);
			game.treatment();
			System.out.println("Game again of same mode ? (Y/N)");
			String response = sc.nextLine();
			if (response.charAt(0) == 'Y' || response.charAt(0) == 'y') {
				game.treatment();
			}
			
		}
	}
}
