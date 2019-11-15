package fr.banab.projet1.game;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GamerMen implements IAttack, IDefend {

	/**
	 * @param combiSize Valeur de la clé pCombiSize récuperée dans le fichier
	 *                  config.properties
	 * @see PropertyValues
	 */

	private static Logger logger = LogManager.getLogger(GamerMen.class);
	protected PropertyValues value = new PropertyValues();

	private int combiSize = Integer.valueOf(value.getCombiSize());

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
				logger.error("la saisie ne correspond pas à des chiffres");
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
