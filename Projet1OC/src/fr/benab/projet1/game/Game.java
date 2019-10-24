package fr.benab.projet1.game;

import java.util.Scanner;


public class Game extends Thread{
	/**
	 * @see IAttack
	 * @see IDefend
	 */
	private IAttack attack;
	private IDefend defender;
	
	public Game (int nbr) {

		if (nbr == 1) {
			System.out.println("Vous avez choisi le mode Challenger");
			defender = new GamerMachine();
			attack = new GamerMen();
		}else if (nbr == 2) {
			System.out.println("Vous avez choisi le mode Defense");
			defender = new GamerMen();
			attack = new GamerMachine();
		}
	}
	
	public String Response (String gamerAtt, String gamerDef) {
		
		String resultat = "";
		
		int i = 0;
		while (i < gamerAtt.length()) {
				if (Integer.valueOf("" + gamerAtt.charAt(i)) > Integer.valueOf("" + gamerDef.charAt(i))) {
					resultat += "-";
				}else if (Integer.valueOf("" + gamerAtt.charAt(i)) < Integer.valueOf("" + gamerDef.charAt(i))) {
					resultat += "+";
				}else resultat += "=";
				i++;
		}		
		return resultat;
	}
	
	public synchronized void treatment() throws Exception {
		int nbrEssai = 0;
		String defense = defender.combiSecret();
		String attaq = attack.proposition();

		while (nbrEssai < 5) {
			String reponse = Response(attaq, defense);
			System.out.println("Proposition : " + attaq +" Reponse " + reponse);
			attaq = attack.resProp(reponse, attaq);

			if (defense.equals(attaq)) {
				System.out.println("La combinaison a �t� trouver : " + defense);
				break;

			}else if (nbrEssai == 4 && !defense.equals(attaq)){
				System.out.println("Vous n'avez pas trouv� la combinaison : " + defense);

			}
			nbrEssai++;
		}
	}
	
	@Override
	public void run() {
		try {
				treatment();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
