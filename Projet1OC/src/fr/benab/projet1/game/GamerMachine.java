package fr.benab.projet1.game;

public class GamerMachine implements IAttack, IDefend {

	@Override
	public String combiSecret() {

		String combiSecret = "";
		for (int i = 0; i < 4; i++) {
			combiSecret += Integer.toString((int) ((Math.random() * (9 - 0)) + 0));
		}
		return combiSecret;
	}

	@Override
	public String proposition() {
		return this.combiSecret();
	}

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
