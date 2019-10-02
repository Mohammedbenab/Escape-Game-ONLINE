package com.sdz.modeJeu;

import Joueurs.*;

public class Challenger implements ModeJeu{

	@Override
	public void modeJeu() {
		Joueurs joueur = new Attaquant();
		Joueurs ordi = new Defenseur();
		ordi.votreProposition(new RandomCombi());
		int nbrEssai = 0;
		
		while(nbrEssai <= 5) {
			joueur.votreProposition(new SaisiCombi());
			
			
			
		}
		
		
		
	}
}