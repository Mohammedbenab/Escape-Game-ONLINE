package Joueurs;

import com.sdz.modeJeu.SaisiCombi;

public class test {

	public static void main(String[] args) {

		Joueurs amine = new Attaquant();
		
		amine.setProposition(new SaisiCombi());
		amine.votreProposition();
		
		
	}

}
