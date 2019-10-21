package fr.benab.projet1.game;

import java.util.Scanner;

public interface IAttack {
	
	public abstract String proposition();
	public default String resProp(String response, String combiAttaq) {
		String combinaison = null;
		System.out.println("\r\nProposer une combinaison");
		Scanner sc = new Scanner(System.in);
		combinaison = sc.nextLine();
		
		return combinaison;
	}

}
