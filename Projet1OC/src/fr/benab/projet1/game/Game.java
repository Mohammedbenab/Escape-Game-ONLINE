package fr.benab.projet1.game;

public class Game extends Thread {
	/**
	 * @see IAttack
	 * @see IDefend
	 */
	private IAttack attack;
	private IDefend defender;
	private GamerMen men;
	private GamerMachine machine;

	public Game(int nbr) throws Exception {

		if (nbr == 1) {
			System.out.println("Vous avez choisi le mode Challenger");
			defender = new GamerMachine();
			attack = new GamerMen();
		} else if (nbr == 2) {
			System.out.println("Vous avez choisi le mode Defense");
			defender = new GamerMen();
			attack = new GamerMachine();
		} else if (nbr == 3) {
			men = new GamerMen();
			machine = new GamerMachine();
		}
	}

	public String Response(String gamerAtt, String gamerDef) {

		String resultat = "";

		int i = 0;
		while (i < gamerAtt.length()) {
			if (Integer.valueOf("" + gamerAtt.charAt(i)) > Integer.valueOf("" + gamerDef.charAt(i))) {
				resultat += "-";
			} else if (Integer.valueOf("" + gamerAtt.charAt(i)) < Integer.valueOf("" + gamerDef.charAt(i))) {
				resultat += "+";
			} else
				resultat += "=";
			i++;
		}
		return resultat;
	}

	public synchronized void treatment() throws Exception {
		int nbrEssai = 0;
		String defense = defender.combiSecret();
		System.out.println("Combinaison d'attaque :");
		String attaq = attack.proposition();
		while (nbrEssai < 5) {
			String reponse = Response(attaq, defense);
			System.out.println("Proposition : " + attaq + " Reponse " + reponse);

			if (defense.equals(attaq)) {
				System.out.println("La combinaison a été trouver : " + defense);
				break;

			} else if (nbrEssai == 4 && !defense.equals(attaq)) {
				System.out.println("La combinaison n'a pas été trouvé: " + defense);
				break;
			}
			System.out.println("Combinaison d'attaque");
			attaq = attack.resProp(reponse, attaq);
			nbrEssai++;
		}
	}

	public void multiPlayer() throws Exception {
		String reponse1, reponse2;
		System.out.println("Attack combi of MenPlayer :");
		String menProp = men.proposition();
		System.out.println("Defense combi of MenPlayer :");
		String machProp = machine.proposition();
		String menDef = men.combiSecret();
		String machineDef = machine.combiSecret();
		int essai = 0;
		while (essai < 5) {
			reponse1 = Response(menProp, machineDef);
			System.out.println("Votre Proposition est: " + menProp + " Reponse " + reponse1);
			reponse2 = Response(machProp, menDef);
			System.out.println("Proposition de l'ordinateur: " + machProp + " Reponse " + reponse2);

			if (menProp.equals(machineDef)) {
				System.out.println("Vous avez gagner, vous avez trouvé la conbinaison " + machineDef);
				break;
			} else if (machProp.equals(menDef)) {
				System.out.println("Vous avez perdu votre cobiniason a été trouvée");
				break;
			} else if (essai == 4) {
				System.out.println("Aucun combinaison n'a été trouvé ");
				System.out.println("Combi MenPlayer : " + menDef);
				System.out.println("Combi ComputerPlayer :" + machineDef);
				break;
			}
			System.out.println("Attack combi of MenPlayer");
			menProp = men.resProp(menProp, machineDef);
			machProp = machine.resProp(reponse2, machProp);
			essai++;
		}

	}

	@Override
	public void run() {

		try {
			treatment();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
