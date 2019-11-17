package fr.benab.projet1.game;

import java.io.IOException;

public class GamerMachine implements IAttack, IDefend {

	/**
	 * @param combiSize Valeur de la clé pCombiSize récuperée dans le fichier
	 *                  config.properties
	 * @see PropertyValues
	 */

	protected PropertyValues value = new PropertyValues();
	protected int combiSize = Integer.valueOf(value.getCombiSize());

	/**
	 * Cette méthode permet de constituer une combinaison secrète.
	 * 
	 * @return Une instance de String, qui correspond à la combinaison secrète du
	 *         joueur.
	 * 
	 * @param conbiSecret pertmettant de stocker la conbinaison.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@Override
	public String combiSecret() throws Exception {
		//int combiSize = Integer.valueOf(value.getCombiSize());
		String combiSecret = "";
		for (int i = 0; i < combiSize; i++) {
			combiSecret += Integer.toString((int) ((Math.random() * (9 - 0)) + 0));
		}
		return combiSecret;
	}

	/**
	 * Cette méthode permet de constituer une combinaison d'attaque.
	 * 
	 * @return Une instance de String, qui correspond à la combinaison d'attaque
	 *         proposé par le joueur.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@Override
	public String proposition() throws NumberFormatException, IOException {
		String prop = null;
		try {
			prop = this.combiSecret();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * Cette méthode permet de repondre par une combinaison après une tantative n+1.
	 * 
	 * @return Une instance de String, qui correspond à la combinaison d'attaque n+1
	 *         du joueur
	 */
	@Override
	public String resProp(String response, String combiAttaq) {
		String reaction = "";
		for (int j = 0; j < response.length(); j++) {
			if (response.charAt(j) == '+') {
				reaction += Integer.toString(Integer.parseInt("" + combiAttaq.charAt(j))
						+ (int) ((Math.random() * (9 - Integer.parseInt("" + combiAttaq.charAt(j))))));
			} else if (response.charAt(j) == '-') {
				reaction += Integer
						.toString((int) ((Math.random() * (Integer.parseInt("" + combiAttaq.charAt(j)) - 0))));
			} else
				reaction += combiAttaq.charAt(j);
		}
		return reaction;
	}
}
