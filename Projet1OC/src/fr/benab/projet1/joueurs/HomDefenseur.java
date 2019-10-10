package fr.benab.projet1.joueurs;

import java.util.Scanner;

public class HomDefenseur extends Defenseur{

	@Override
	public String reponse() {
		return null;
		
	}

	@Override
	public int combiSecret() {
		
		System.out.println("Choisir une combinaison");
		Scanner sc = new Scanner(System.in);
		int combinaison = sc.nextInt();
		return combinaison;
		
	}

}
