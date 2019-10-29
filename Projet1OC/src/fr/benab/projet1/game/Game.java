package fr.benab.projet1.game;

/**
 * Game est la classe representant le moteur du jeu
 * 
 * @author Benabdallah
 * @version 1.0
 *
 */
public class Game {
	/**
	 * "attaque" cette voriable peut *etre modifier mais doit permettre d'identifier
	 * un joueur en position d'attaque.
	 * 
	 * @see IAttack Interface pouvant être modifier, et qui sera implémenté dans une
	 *      classe pour créer une combinaison d'attaque.
	 * @see IDefend Interface pouvant être modifier, et qui sera implémenté dans une
	 *      classe pour créer une combinaison d'attaque.
	 * 
	 * @see GamerMen Classes qui peut etre modifié, et qui permet d'instancier un
	 *      joueur Ordinateur.
	 * @see GamerMachine Classes qui peut etre modifié, et qui permet d'instancier
	 *      un joueur Homme.
	 * @param devMode permet a l'utilisateur d'activer le mode développeur pour
	 *                voire la solution du joueur
	 */
	private IAttack attack;
	private IDefend defender;
	private GamerMen men;
	private GamerMachine machine;
	private final String devMode = "7777";

	/**
	 * La méthode Game(int nbr) permet d'instancier les joueurs en fonction du mode
	 * de jeu choisie par l'utilisateur.
	 * 
	 * @param nbr      Choix numerique saisie par l'utilisateur en fonction des
	 *                 proposition du Menu.
	 * @param defender Instanciation d'un joueur en mode defense
	 * @param attack   Intanciation d'un joueur en mode attaque
	 * @param men      instanciation d'un joueur homme
	 * @param machine  instanciation d'un joueur qui sera un ordinateur
	 */

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
			System.out.println("Vous avez choisi le mode Duel");
			men = new GamerMen();
			machine = new GamerMachine();
		}
	}

	/**
	 * La méthode Response() compare les 2 combinaisons saisie chacune par les deux
	 * joueurs. Le joueur attaquant et le joueur défenseur.
	 * 
	 * @param gamerAtt La combinaison de l'attaquant
	 * @param gamerDef La combinaison du defenseur
	 * @return Permet de récupérer le résultat sous forme d'une chaine de caractére.
	 *         Pour facilité la combinaison d'attaque de la prochaine tantative.
	 */
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

	/**
	 * La méthode treatment() est en quelque sorte le moteur de notre jeu.
	 * 
	 * @param nbrEssai represente le nombre d'essai (ne peut depasser 5 tantative)
	 *                 que le joueur en possition d'attaque aura pour trouver la
	 *                 combinaison de son adversaire.
	 * @param defense  est la combinaison secrète choisie par le joueur
	 * @param attaq    est la combinaison proposer par le joueur dans le but de
	 *                 trouver la combinaison secréte de l'adversaire
	 * @param reponse  stock le résultat de la méthode Response() pour faire une
	 *                 proposition de combinaison d'attaque.
	 * @throws Exception elle est levée si le joueur ne saisie pas de combinaison ou
	 *                   si la combinaison n'est pas constituée de quatre chiffres
	 *                   (par defaut).
	 */

	public void treatment() throws Exception {
		int nbrEssai = 0;
		String defense = defender.combiSecret();
		System.out.println("\r\nCombinaison d'attaque :");
		String attaq = attack.proposition();

		if (!devMode.equals(attaq)) {
			System.out.println("\r\nLe mode developpeur n'est pas activé");
		}
		while (nbrEssai < 5) {

			if (devMode.equals(attaq)) {
				System.out.println("\r\nVous avez activé le mode developpeur");
				System.out.println("La solution du defenseur est :" + defense);
			}
			String reponse = Response(attaq, defense);
			System.out.println("\r\nProposition : " + attaq + " Reponse " + reponse);

			if (defense.equals(attaq)) {
				System.out.println("\r\nLa combinaison a été trouver : " + defense);
				break;

			} else if (nbrEssai == 4 && !defense.equals(attaq)) {
				System.out.println("\r\nLa combinaison n'a pas été trouvé: " + defense);
				break;
			}
			System.out.println("\r\nCombinaison d'attaque");
			attaq = attack.resProp(reponse, attaq);
			nbrEssai++;
		}
	}

	/**
	 * La méthode multiPlayer() permet à deux joueurs de jouer simultanement. Le
	 * premier qui trouve la combinaison avant les cinq tantive à gagné.
	 * 
	 * @param devMode  permet a l'utilisateur de voire la solution de l'adversaire
	 * @param reponse1 permet de stocker le resultat de la méthode Response()
	 *                 comparant la proposition du joueur Homme, et le combinaison
	 *                 secrète de l'Ordinateur.
	 * @param reponse2 permet de stocker le resultat de la méthode Response()
	 *                 comparant la proposition de l'ordinateur, et le combinaison
	 *                 secrète du joueur homme.
	 * @param menProp  combinaison d'attaque proposé par le joueur homme.
	 * @param machProp combinaison d'attaque proposé par le joueur ordinateur.
	 * @param menDef   combinaison de défense proposé par le joueur homme.
	 * @param machDef  combinaison de défense proposé par le joueur ordinateur.
	 * @param essai    represente le nombre d'essai (ne peut depasser 5 tantative)
	 *                 que le joueur en possition d'attaque aura pour trouver la
	 *                 combinaison de son adversaire.
	 * @throws Exception elle est levée si la saisie ne correspond pas à quatre
	 *                   chiffres
	 */

	public void multiPlayer() throws Exception {
		String reponse1, reponse2;
		System.out.println("\r\nAttack combi of MenPlayer :");
		String menProp = men.proposition();
		System.out.println("Defense combi of MenPlayer :");
		String machProp = machine.proposition();
		String menDef = men.combiSecret();
		String machDef = machine.combiSecret();
		int essai = 0;
		if (!devMode.equals(menProp)) {
			System.out.println("\r\nMode developpeur non activé !");
		}
		while (essai < 5) {

			if (devMode.equals(menProp)) {
				System.out.println("\r\nVous avez activé le mode developpeur");
				System.out.println("La solution du defenseur est :" + machDef);
			}

			reponse1 = Response(menProp, machDef);
			System.out.println("\r\nVotre Proposition est: " + menProp + " Reponse " + reponse1);
			reponse2 = Response(machProp, menDef);
			System.out.println("Proposition de l'ordinateur: " + machProp + " Reponse " + reponse2);

			if (menProp.equals(machDef)) {
				System.out.println("\r\nVous avez gagner, vous avez trouvé la conbinaison " + machProp);
				break;
			} else if (machProp.equals(menDef)) {
				System.out.println("\r\nVous avez perdu votre cobiniason a été trouvée");
				break;
			} else if (essai == 4) {
				System.out.println("\r\nAucun combinaison n'a été trouvé ");
				System.out.println("Combi MenPlayer : " + menDef);
				System.out.println("Combi ComputerPlayer :" + machProp);
				break;
			}
			System.out.println("\r\nAttack combi of MenPlayer");
			menProp = men.resProp(menProp, machProp);
			machProp = machine.resProp(reponse2, machProp);
			essai++;
		}

	}

}
