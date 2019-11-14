package fr.banab.projet1.game;

public class GamerMachine implements IAttack, IDefend {

	/**
	 * @param combiSize Valeur de la cl� pCombiSize r�cuper�e dans le fichier
	 *                  config.properties
	 * @see PropertyValues
	 */

	protected PropertyValues value = new PropertyValues();
	private int combiSize = Integer.valueOf(value.getCombiSize());

	/**
	 * Cette m�thode permet de constituer une combinaison secr�te.
	 * 
	 * @return Une instance de String, qui correspond � la combinaison secr�te du
	 *         joueur.
	 * 
	 * @param conbiSecret pertmettant de stocker la conbinaison.
	 */
	@Override
	public String combiSecret() {

		String combiSecret = "";
		for (int i = 0; i < combiSize; i++) {
			combiSecret += Integer.toString((int) ((Math.random() * (9 - 0)) + 0));
		}
		return combiSecret;
	}

	/**
	 * Cette m�thode permet de constituer une combinaison d'attaque.
	 * 
	 * @return Une instance de String, qui correspond � la combinaison d'attaque
	 *         propos� par le joueur.
	 */
	@Override
	public String proposition() {
		return this.combiSecret();
	}

	/**
	 * Cette m�thode permet de repondre par une combinaison apr�s une tantative n+1.
	 * 
	 * @return Une instance de String, qui correspond � la combinaison d'attaque n+1
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
