package fr.banab.projet1.game;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GamerMen implements IAttack, IDefend {

	/**
	 * @param combiSize Valeur de la cl� pCombiSize r�cuper�e dans le fichier
	 *                  config.properties
	 * @see PropertyValues
	 */

	private static Logger logger = LogManager.getLogger(GamerMen.class);
	protected PropertyValues value = new PropertyValues();

	private int combiSize = Integer.valueOf(value.getCombiSize());

	/**
	 * @return Une instance de String, et permet de recup�rer une combinaison grace
	 *         � la saisie clavier. c'est une combianison secr�te du joueur.
	 * @throws Exeption lev� si la combinaison n'est pas constitu�e de quatre
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
			System.out.println("Choice your combinaison");

			try {
				combinaison = sc.nextLine();
				logger.info("Combinaison saisie par le joueur homme");
				if (combinaison.length() != combiSize) {
					logger.warn("La taille de la combinaison est incorrect");
				} else {
					isOk = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("la saisie ne correspond pas � des chiffres");
			}
		}
		return combinaison;
	}

	/**
	 * Cette m�thode permet de constituer une combinaison d'attaque et retourne
	 * celle-ci dans une variable.
	 * 
	 * @return Une instance de String, et permet de r�cup�rer une combinaison
	 *         d'attaque gace � la m�thode combiSecr�te().
	 * @throws Une exeption similaire celle de la combinaison secr�te peut �tre
	 *             lev�e.
	 */
	@Override
	public String proposition() throws Exception {
		return this.combiSecret();
	}

	/**
	 * Cette m�thode permet de constituer une combinaison d'attaque n+1 et retourne
	 * celle-ci dans une variable.
	 * 
	 * @return Une instance de String, et permet de r�cup�rer une combinaison
	 *         d'attaque n+1 gace � la m�thode combiSecr�te().
	 * @throws Une exeption similaire celle de la combinaison secr�te peut �tre
	 *             lev�e.
	 */
	@Override
	public String resProp(String response, String proposition) throws Exception {
		return this.combiSecret();
	}

}
