package com.sdz.modeJeu;

import Joueurs.*;

public class Challenger implements ModeJeu{

	@Override
	public void modeJeu() {
		Joueurs attaquant = new Attaquant();
		Joueurs defenseur = new Defenseur();
		int nbrEssai = 0;
		
		while(nbrEssai <= 5) {
			attaquant.votreProposition(new SaisiCombi());
			defenseur.votreProposition(new RandomCombi());
		}
		
		
		
	}
}