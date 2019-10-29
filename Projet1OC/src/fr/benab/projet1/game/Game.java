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
	 * @see IAttack Interface pouvant �tre modifier, et qui sera impl�ment� dans une
	 *      classe pour cr�er une combinaison d'attaque.
	 * @see IDefend Interface pouvant �tre modifier, et qui sera impl�ment� dans une
	 *      classe pour cr�er une combinaison d'attaque.
	 * 
	 * @see GamerMen Classes qui peut etre modifi�, et qui permet d'instancier un
	 *      joueur Ordinateur.
	 * @see GamerMachine Classes qui peut etre modifi�, et qui permet d'instancier
	 *      un joueur Homme.
	 */
	private IAttack attack;
	private IDefend defender;
	private GamerMen men;
	private GamerMachine machine;

	/**
	 * La m�thode Game(int nbr) permet d'instancier les joueurs en fonction du mode
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
			men = new GamerMen();
			machine = new GamerMachine();
		}
	}

	/**
	 * La m�thode Response() compare les 2 combinaisons saisie chacune par les deux
	 * joueurs. Le joueur attaquant et le joueur d�fenseur.
	 * 
	 * @param gamerAtt La combinaison de l'attaquant
	 * @param gamerDef La combinaison du defenseur
	 * @return Permet de r�cup�rer le r�sultat sous forme d'une chaine de caract�re.
	 *         Pour facilit� la combinaison d'attaque de la prochaine tantative.
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
	 * La m�thode treatment() est en quelque sorte le moteur de notre jeu.
	 * 
	 * @param nbrEssai represente le nombre d'essai (ne peut depasser 5 tantative)
	 *                 que le joueur en possition d'attaque aura pour trouver la
	 *                 combinaison de son adversaire.
	 * @param defense  est la combinaison secr�te choisie par le joueur
	 * @param attaq    est la combinaison proposer par le joueur dans le but de
	 *                 trouver la combinaison secr�te de l'adversaire
	 * @param reponse  stock le r�sultat de la m�thode Response() pour faire une
	 *                 proposition de combinaison d'attaque.
	 * @throws Exception elle est lev�e si le joueur ne saisie pas de combinaison ou
	 *                   si la combinaison n'est pas constitu�e de quatre chiffres
	 *                   (par defaut).
	 */

	public synchronized void treatment() throws Exception {
		int nbrEssai = 0;
		String defense = defender.combiSecret();
		System.out.println("Combinaison d'attaque :");
		String attaq = attack.proposition();
		while (nbrEssai < 5) {
			String reponse = Response(attaq, defense);
			System.out.println("Proposition : " + attaq + " Reponse " + reponse);

			if (defense.equals(attaq)) {
				System.out.println("La combinaison a �t� trouver : " + defense);
				break;

			} else if (nbrEssai == 4 && !defense.equals(attaq)) {
				System.out.println("La combinaison n'a pas �t� trouv�: " + defense);
				break;
			}
			System.out.println("Combinaison d'attaque");
			attaq = attack.resProp(reponse, attaq);
			nbrEssai++;
		}
	}

	/**
	 * La m�thode multiPlayer() permet � deux joueurs de jouer simultanement. Le
	 * premier qui trouve la combinaison avant les cinq tantive � gagn�.
	 * 
	 * @param reponse1 permet de stocker le resultat de la m�thode Response()
	 *                 comparant la proposition du joueur Homme, et le combinaison
	 *                 secr�te de l'Ordinateur.
	 * @param reponse2 permet de stocker le resultat de la m�thode Response()
	 *                 comparant la proposition de l'ordinateur, et le combinaison
	 *                 secr�te du joueur homme.
	 * @param menProp  combinaison d'attaque propos� par le joueur homme.
	 * @param machProp combinaison d'attaque propos� par le joueur ordinateur.
	 * @param menDef   combinaison de d�fense propos� par le joueur homme.
	 * @param machDef  combinaison de d�fense propos� par le joueur ordinateur.
	 * @param essai    represente le nombre d'essai (ne peut depasser 5 tantative)
	 *                 que le joueur en possition d'attaque aura pour trouver la
	 *                 combinaison de son adversaire.
	 * @throws Exception elle est lev�e si la saisie ne correspond pas � quatre
	 *                   chiffres
	 */

	public void multiPlayer() throws Exception {
		String reponse1, reponse2;
		System.out.println("Attack combi of MenPlayer :");
		String menProp = men.proposition();
		System.out.println("Defense combi of MenPlayer :");
		String machProp = machine.proposition();
		String menDef = men.combiSecret();
		int essai = 0;
		while (essai < 5) {
			reponse1 = Response(menProp, machProp);
			System.out.println("Votre Proposition est: " + menProp + " Reponse " + reponse1);
			reponse2 = Response(machProp, menDef);
			System.out.println("Proposition de l'ordinateur: " + machProp + " Reponse " + reponse2);

			if (menProp.equals(machProp)) {
				System.out.println("Vous avez gagner, vous avez trouv� la conbinaison " + machProp);
				break;
			} else if (machProp.equals(menDef)) {
				System.out.println("Vous avez perdu votre cobiniason a �t� trouv�e");
				break;
			} else if (essai == 4) {
				System.out.println("Aucun combinaison n'a �t� trouv� ");
				System.out.println("Combi MenPlayer : " + menDef);
				System.out.println("Combi ComputerPlayer :" + machProp);
				break;
			}
			System.out.println("Attack combi of MenPlayer");
			menProp = men.resProp(menProp, machProp);
			machProp = machine.resProp(reponse2, machProp);
			essai++;
		}

	}

}
