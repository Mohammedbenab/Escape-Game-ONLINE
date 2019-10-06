package fr.benab.escapegame.proposition;

import fr.benab.escapegame.combinaison.RandomCombi;
import fr.benab.escapegame.combinaison.SaisiCombi;
import fr.benab.escapegame.imode.ModeJeu;
import fr.benab.escapegame.joueurs.*;

public class Challenger implements ModeJeu{

	@Override
	public void modeJeu() {
		
		
		Joueurs joueur = new Attaquant();
		Joueurs ordi = new Defenseur();
		char[] tabAttaq = new char[4];
		char[] tabDefense = new char [4];
		tabAttaq = null;
		tabDefense = null;
		int combiDefense = ordi.votreProposition(new RandomCombi());
		tabDefense = Integer.toString(combiDefense).toCharArray();
		
		int nbrEssai = 5;
		int combiAttaque;
		String resultat = "";
		
		
		while(nbrEssai > 0) {
			
				//resultat ="";
				combiAttaque = 0;
				
				while(combiAttaque == 0) {
					
					combiAttaque = joueur.votreProposition(new SaisiCombi());
					System.out.println("Le combinaison attaque: " + combiAttaque);
					tabAttaq = Integer.toString(combiAttaque).toCharArray();
					
					if (tabAttaq.length != 4 || tabAttaq == null) {
						System.out.println("Votre combinaison doit être constituée de 4 chiffres");
						combiAttaque = 0;
					}
				}
					
				int i =0;
				while (i < tabAttaq.length) {
					if (tabAttaq[i] > tabDefense[i]) {
						resultat += "-";
					}else if (tabAttaq[i] < tabDefense[i]) {
						resultat += "+";
					}else resultat += "=";
					i++;
				}
				if (tabAttaq.equals(tabDefense)) {
					System.out.println("Felicitation vous avec trouvez la combinaison: " + tabDefense);
					System.exit (0);
				}
				System.out.println("Proposition :" + combiAttaque + " -> Réponse :" + resultat);
				
				nbrEssai--;
	
		}
	
	}
}