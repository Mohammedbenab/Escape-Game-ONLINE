package fr.benab.projet1.game;

import java.util.Scanner;

public class GamerMen implements IAttack, IDefend {

	/**
	 * @return Une instance de String, et permet de recupérer une combinaison grace
	 *         à la saisie clavier. c'est une combianison secrète du joueur.
	 * @throws Exeption levé si la combinaison n'est pas constituée de quatre
	 *                  chiffres.
	 * @param isOk maintien la boucle tant que la saisie est vide ou que la
	 *             combinaison saisie n'est pas confrome aux exigences du jeu.
	 */
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

	/**
	 * Cette méthode permet de constituer une combinaison d'attaque et retourne
	 * celle-ci dans une variable.
	 * 
	 * @return Une instance de String, et permet de récupérer une combinaison
	 *         d'attaque gace à la méthode combiSecrète().
	 * @throws Une exeption similaire celle de la combinaison secrète peut être
	 *             levée.
	 */
	@Override
	public String proposition() throws Exception {
		return this.combiSecret();
	}

	/**
	 * Cette méthode permet de constituer une combinaison d'attaque n+1 et retourne
	 * celle-ci dans une variable.
	 * 
	 * @return Une instance de String, et permet de récupérer une combinaison
	 *         d'attaque n+1 gace à la méthode combiSecrète().
	 * @throws Une exeption similaire celle de la combinaison secrète peut être
	 *             levée.
	 */
	@Override
	public String resProp(String response, String proposition) throws Exception {
		return this.combiSecret();
	}

}
