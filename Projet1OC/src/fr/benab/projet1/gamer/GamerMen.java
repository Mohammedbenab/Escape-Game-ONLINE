package fr.benab.projet1.gamer;

import java.util.Scanner;

public class GamerMen implements Attaquant, Defenseur{

	@Override
	public String proposition() {
		
		System.out.println("Choisir une combinaison");
		Scanner sc = new Scanner(System.in);
		String combinaison = sc.nextLine();
		return combinaison;
		
	}

	@Override
	public String combiSecret() {
		return null;
	}


}
