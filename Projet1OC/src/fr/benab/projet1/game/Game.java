package fr.benab.projet1.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Game est la classe representant le moteur du jeu
 * 
 * @author Benabdallah
 * @version 1.0
 *
 */
public class Game {

	private static Logger logger = LogManager.getLogger(Game.class);
	protected PropertyValues value = new PropertyValues();

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
	 * @param devMode  permet a l'utilisateur d'activer le mode développeur pour
	 *                 voire la solution du joueur.
	 * 
	 * @param devMode  valeur de la clé pDevMode récupérée dans le fichier
	 *                 config.properties. Permet d'activer le mode développeur
	 * @param nbrEssai valeur de la clé pNbrEssai récupérée dans le fichier
	 *                 config.properties. Correspond au nombre d'essai possible.
	 * @param sizeCombi     valeur de la clé pCombiSize récupérée dans le fichier
	 *                 config.properties. Correspond a la taille de la combinaison.
	 */
	private IAttack attack;
	private IDefend defender;
	private GamerMen men;
	private GamerMachine machine;
	protected boolean devMode = Boolean.parseBoolean(value.getDevMode());
	private int nbrEssai = Integer.valueOf(value.getNbrEssai());
	private int sizeCombi = Integer.valueOf(value.getCombiSize());

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
			System.out.println("You have choice Challenger mode");
			defender = new GamerMachine();
			attack = new GamerMen();
			logger.info("Instanciation d'un attaquant et un defenseur");
		} else if (nbr == 2) {
			System.out.println("You have choice Defense mode");
			defender = new GamerMen();
			attack = new GamerMachine();
			logger.info("Instanciation d'un attaquant et un defenseur");
		} else if (nbr == 3) {
			System.out.println("You have choice Dual mode");
			men = new GamerMen();
			machine = new GamerMachine();
			logger.info("Instanciation d'un joueur homme et machine");
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
		System.out.println("The combinaison must have " + sizeCombi + " numbers");
		String defense = defender.combiSecret();
		logger.info("Combinaison de defense saisie");
		System.out.println("\r\nCombinaison of Attack :");
		String attaq = attack.proposition();
		logger.info("Combinaison d'attaque saisie");
		System.out.println(sizeCombi);
		System.out.println(nbrEssai);
		System.out.println(devMode);

		if (!devMode) {
			System.out.println("\r\nDeveloper mode not activated");
		}
		while (nbrEssai > 0) {

			if (devMode) {
				System.out.println("\r\nDeveloper mode actived");
				System.out.println("The solution of defense is :" + defense);
				}
	
			String reponse = Response(attaq, defense);
			System.out.println("\r\nProposition : " + attaq + " Reponse " + reponse);

			if (defense.equals(attaq)) {
				System.out.println("\r\nThe combinaison was found : " + defense);
				break;

			} else if (nbrEssai == 1 && !defense.equals(attaq)) {
				System.out.println("\r\nThe combinaison was't found : " + defense);
				break;
			}
			System.out.println("\r\nAttack combinaison");
			attaq = attack.resProp(reponse, attaq);
			nbrEssai--;
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
		System.out.println("The combinaison must have " + sizeCombi + " numbers");
		String reponse1, reponse2;
		System.out.println("\r\nAttack combinaison of MenPlayer :");
		String menProp = men.proposition();
		logger.info("Combinaison d'attaque men saisie");
		System.out.println("Defense combinaison of MenPlayer :");
		String machProp = machine.proposition();
		logger.info("Combinaison d'attaque machine saisie");
		String menDef = men.combiSecret();
		logger.info("Combinaison de def men saisie");
		String machDef = machine.combiSecret();
		logger.info("Combinaison de def machine saisie");

		if (!devMode) {
			System.out.println("\r\nDeveloper mode not activated");
		}
		while (nbrEssai > 0) {

			if (devMode) {

				System.out.println("\r\nDeveloper mode actived");
				System.out.println("The solution of defense is :" + machDef);
				}

			reponse1 = Response(menProp, machDef);
			System.out.println("\r\nVotre Proposition is: " + menProp + " Response " + reponse1);
			reponse2 = Response(machProp, menDef);
			System.out.println("Proposition of computer is: " + machProp + " Response " + reponse2);

			if (menProp.equals(machDef)) {
				System.out.println("\r\nYou have win, you found combinaison " + machProp);
				break;
			} else if (machProp.equals(menDef)) {
				System.out.println("\r\nYou have lose, combinaison isn't found");
				break;
			} else if (nbrEssai == 1) {
				System.out.println("\r\nCombinaison of defenser isn't found ");
				System.out.println("Combinaison of MenPlayer : " + menDef);
				System.out.println("Combinaison of ComputerPlayer :" + machProp);
				break;
			}
			System.out.println("\r\nAttack combinaison of MenPlayer");
			menProp = men.resProp(menProp, machProp);
			machProp = machine.resProp(reponse2, machProp);
			nbrEssai--;
		}

	}

}
