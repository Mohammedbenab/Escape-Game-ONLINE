package fr.benab.projet1.gamer;

import java.util.Scanner;

public class GamerMen implements IAttack, IDefend{

	@Override
	public String combiSecret() {
		System.out.println("Choisir une combinaison secrète");
		Scanner sc = new Scanner(System.in);
		String combinaison = sc.nextLine();
		return combinaison;
	}

	@Override
	public String proposition(String[] reponse) {
		
			int combinaison = 0;
			String proposition = null;
			
			while (proposition.length() < 4) {
			System.out.println("Choisir une combinaison");
			Scanner sc = new Scanner(System.in);
			combinaison = sc.nextInt();
			proposition = String.valueOf(combinaison);
			}
			return proposition;
	}


}
