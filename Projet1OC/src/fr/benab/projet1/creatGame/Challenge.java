package fr.benab.projet1.creatGame;

import fr.benab.projet1.gamer.GamerMachine;
import fr.benab.projet1.gamer.GamerMen;

public class Challenge implements GameMode{
	
	@Override
	public void gameMode() {
		
		String reponse = null;
		Menu menu = new Menu();
		GamerMen gamerMen = new GamerMen();
		GamerMachine gamerMachine = new GamerMachine();
		
		int nbrEssai = 0;
		String gAtt = null;
		String gDef = null;
		gDef = gamerMachine.combiSecret();
		
		while (nbrEssai < 5) {
			gAtt = gamerMen.proposition(reponse);
			menu.Reponse(gAtt, gDef);
			if (gAtt.equals(gDef)) {
				System.out.println("Felicitation vous avez trouver la combinaison : " + gDef);
				break;
			}else if (!gAtt.equals(gDef) && nbrEssai == 5) {
				System.out.println("Bien jouer, mais vous n'avez pas trouver la combinaison !");
				break;
			}else nbrEssai++;
		}
		
	}
}
