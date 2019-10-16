package fr.benab.projet1.gamer;

import java.util.Scanner;

public class GamerMen implements IAttack, IDefend{

	@Override
	public String combiSecret() {
		System.out.println("\n\rChoisir une combinaison secrète");
		Scanner sc = new Scanner(System.in);
		String combiSecret = sc.nextLine();
		return combiSecret;
	}

	@Override
	public String proposition(String reponse) {
		
		String combinaison = null;
		if (reponse == null || reponse != null) {
				System.out.println("\r\nChoisir une combinaison");
				Scanner sc = new Scanner(System.in);
				combinaison = sc.nextLine();
		}
		return combinaison;
	}


}
