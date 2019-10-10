package fr.benab.projet1.joueurs;

import java.util.Scanner;

public class HomAttaquant extends Attaquant{

	@Override
	public int proposition() {
		
		System.out.println("Choisir une combinaison");
		Scanner sc = new Scanner(System.in);
		int combinaison = sc.nextInt();
		return combinaison;
		
	}

}
