package fr.benab.projet1.game;

import java.util.Scanner;


public class GamerMen implements IAttack, IDefend{

	@Override
	public String combiSecret() {
		boolean isOk = false;
		String combiSecret = null;
		while (!isOk) {
			System.out.println("\n\rChoisir une combinaison secrète");
			Scanner sc = new Scanner(System.in);
			combiSecret = sc.nextLine();
			if (combiSecret.length() < 4 || combiSecret.length() > 5) {
				System.out.println("Combi incorrect !");
			}else isOk = true;
		}
		return combiSecret;
	}

	@Override
	public String proposition() throws Exception{
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
