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
	public String proposition() {
		String combinaison = null;
		System.out.println("\r\nProposer une combinaison");
		Scanner sc = new Scanner(System.in);
		combinaison = sc.nextLine();
		
		return combinaison;
	}
}
