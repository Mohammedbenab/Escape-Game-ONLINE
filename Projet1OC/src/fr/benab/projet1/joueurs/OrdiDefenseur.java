package fr.benab.projet1.joueurs;

import java.util.Random;

public class OrdiDefenseur extends Defenseur{

	@Override
	public String reponse() {
		return null;

	}

	@Override
	public int combiSecret() {
		Random nombre = new Random();
		int combinaison = nombre.nextInt(8998 + 1) + 1000;
		return combinaison;

	}

}
