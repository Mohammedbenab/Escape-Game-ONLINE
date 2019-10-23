package fr.benab.projet1.game;

import java.util.Scanner;

public interface IAttack {
	
	public abstract String proposition() throws Exception;
	public default String resProp(String response, String combiAttaq) {
		boolean isOk = false;
		String combinaison = null;
		Scanner sc = new Scanner(System.in);
		while (!isOk) {
			System.out.println("\r\nProposer une combinaison");
			try {
			combinaison = sc.nextLine();
			if (combinaison.length() < 4 || combinaison.length() > 4) {
					System.err.println("Taille de la combi incorrect !");
			}else isOk = true;
			}catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error in your choice !");
			}
		}
		return combinaison;
	}

}
