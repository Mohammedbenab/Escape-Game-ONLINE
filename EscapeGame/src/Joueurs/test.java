package Joueurs;

import com.sdz.modeJeu.*;

public class test {

	public static void main(String[] args) {

		Joueurs joueur1 = new Attaquant();
		Joueurs ordi = new Defenseur();
	
		SaisiCombi combinaison = new SaisiCombi();
		joueur1.votreProposition(combinaison);
		RandomCombi combinaison1 = new RandomCombi();
		ordi.votreProposition(combinaison1);
	
		

				
		
		
	}

}
