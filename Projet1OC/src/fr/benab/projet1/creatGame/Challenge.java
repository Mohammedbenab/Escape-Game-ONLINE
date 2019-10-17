package fr.benab.projet1.creatGame;

import fr.benab.projet1.gamer.GamerMachine;
import fr.benab.projet1.gamer.GamerMen;

public class Challenge implements GameMode{
	
	@Override
	public void gameMode() {
		
		String reponse = null;
		//Builder sMenu = new Menu();
		Menu menu = (new BuildGame(new Menu())).creatMenu();
		GamerMen gamerMen = (new BuildGame(new GamerMen())).creatGamerMen();
		GamerMachine gamerMachine = (new BuildGame(new GamerMachine())).creatGamerMachine();
		
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
