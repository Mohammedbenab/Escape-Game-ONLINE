package fr.benab.projet1.main;

import fr.benab.projet1.creatGame.Game;
import fr.benab.projet1.gamer.GamerMachine;
import fr.benab.projet1.gamer.GamerMen;


public class Main {

	public static void main(String[] args) {
		GamerMachine combia= new GamerMachine();
		GamerMen combidef = new GamerMen();
		Game game = new Game();
		String def = combidef.combiSecret();
		String attaq = combia.proposition();
		int nbr = 0;
		System.out.println(def + " " + attaq);
		/*
		 * Code test if a men game defense
		 */
		 	while(nbr< 5) {
			String r= game.Response(attaq, def);
				System.out.println("Proposition : " + attaq +" Reponse " + r);
				attaq = combia.resProp(r, attaq);
				nbr++;
			}
		
		
	}
}
