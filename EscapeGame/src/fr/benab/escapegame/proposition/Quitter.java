package fr.benab.escapegame.proposition;

import fr.benab.escapegame.mode.ModeJeu;

public class Quitter implements ModeJeu{

	@Override
	public void modeJeu() {
		System.out.println("A bientôt !");
	}

}
