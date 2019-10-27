package fr.benab.projet1.game;

import java.util.Scanner;

public class GamerMen implements IAttack, IDefend {
	@Override
	public String combiSecret() throws Exception {
		boolean isOk = false;
		String combinaison = null;
		Scanner sc = new Scanner(System.in);
		while (!isOk) {
			System.out.println("\r\nChoice your combinaison");

			try {
				combinaison = sc.nextLine();
				if (combinaison.length() != 4) {
					System.err.println("Size of combi incorrect !");
				} else {
					isOk = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error in your choice !");
			}
		}
		return combinaison;
	}

	@Override
	public String proposition() throws Exception {
		return this.combiSecret();
	}

	@Override
	public String resProp(String response, String proposition) throws Exception {
		return this.combiSecret();
	}


}
